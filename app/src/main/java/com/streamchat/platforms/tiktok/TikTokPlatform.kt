package com.streamchat.platforms.tiktok

import com.streamchat.platforms.core.*
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton
import java.util.UUID
import org.json.JSONObject
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener

@Singleton
class TikTokPlatform @Inject constructor(
    private val client: OkHttpClient
) : StreamPlatform {
    private var webSocket: WebSocket? = null
    private val usernameRegex = Regex("@([\\w._]+)")
    private val messageFlow = MutableSharedFlow<StreamMessage>()
    
    override suspend fun connect(url: String) {
        Timber.d("Спроба підключення до TikTok URL: $url")
        
        val username = extractUsername(url)
        if (username == null) {
            Timber.e("Не вдалося витягнути ім'я користувача з URL: $url")
            throw IllegalArgumentException("Невірний формат URL TikTok")
        }
        
        Timber.d("Витягнуто ім'я користувача: $username")
        
        val request = Request.Builder()
            .url("wss://tiktok-chat-websocket.herokuapp.com")
            .build()
            
        webSocket = client.newWebSocket(request, object : WebSocketListener() {
            override fun onOpen(webSocket: WebSocket, response: okhttp3.Response) {
                Timber.d("WebSocket відкрито")
                val connectMessage = JSONObject().apply {
                    put("type", "connect")
                    put("username", username)
                }.toString()
                webSocket.send(connectMessage)
            }
            
            override fun onFailure(webSocket: WebSocket, t: Throwable, response: okhttp3.Response?) {
                Timber.e(t, "Помилка WebSocket")
            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                try {
                    val json = JSONObject(text)
                    val type = json.optString("type", "")
                    
                    when (type) {
                        "chat" -> handleChatMessage(json)
                        "gift" -> handleGiftMessage(json)
                        "like" -> handleLikeMessage(json)
                    }
                } catch (e: Exception) {
                    Timber.e(e, "Помилка обробки повідомлення: $text")
                }
            }
        })
    }
    
    override suspend fun disconnect() {
        Timber.d("Відключення від TikTok")
        webSocket?.close(1000, "Нормальне закриття")
        webSocket = null
    }
    
    override fun getMessages(): Flow<StreamMessage> = messageFlow.asSharedFlow()
    
    override fun isValidUrl(url: String): Boolean {
        Timber.d("Перевірка URL TikTok: $url")
        return url.contains("tiktok.com") && extractUsername(url) != null
    }
    
    private fun extractUsername(url: String): String? {
        Timber.d("Спроба витягнути ім'я користувача з URL: $url")
        return usernameRegex.find(url)?.groupValues?.get(1)?.also {
            Timber.d("Знайдено ім'я користувача: $it")
        }
    }

    private fun handleChatMessage(data: JSONObject) {
        val nickname = data.optString("nickname")
        val comment = data.optString("comment")
        
        if (nickname.isBlank() || comment.isBlank()) return

        val message = StreamMessage(
            id = UUID.randomUUID().toString(),
            text = comment,
            originalText = comment,
            author = nickname,
            timestamp = System.currentTimeMillis(),
            platform = PlatformType.TIKTOK,
            type = MessageType.REGULAR,
            isTranslated = false
        )

        messageFlow.tryEmit(message)
        Timber.d("Оброблено чат повідомлення: $nickname - $comment")
    }

    private fun handleGiftMessage(data: JSONObject) {
        val nickname = data.optString("nickname")
        val giftName = data.optString("giftName")
        val giftValue = data.optInt("diamondCount", 0)
        val giftImageUrl = data.optString("giftPictureUrl")
        
        if (nickname.isBlank() || giftName.isBlank()) return

        val message = StreamMessage(
            id = UUID.randomUUID().toString(),
            text = "Відправив(ла) подарунок $giftName",
            originalText = "Sent gift $giftName",
            author = nickname,
            timestamp = System.currentTimeMillis(),
            platform = PlatformType.TIKTOK,
            type = MessageType.GIFT,
            isTranslated = false,
            gifts = listOf(
                Gift(
                    name = giftName,
                    value = giftValue,
                    imageUrl = if (giftImageUrl.isBlank()) null else giftImageUrl
                )
            )
        )

        messageFlow.tryEmit(message)
        Timber.d("Оброблено подарунок: $nickname - $giftName ($giftValue)")
    }

    private fun handleLikeMessage(data: JSONObject) {
        val nickname = data.optString("nickname")
        val likeCount = data.optInt("likeCount", 0)
        
        if (nickname.isBlank()) return

        val message = StreamMessage(
            id = UUID.randomUUID().toString(),
            text = "Поставив(ла) $likeCount лайків",
            originalText = "Sent $likeCount likes",
            author = nickname,
            timestamp = System.currentTimeMillis(),
            platform = PlatformType.TIKTOK,
            type = MessageType.REGULAR,
            isTranslated = false,
            likes = likeCount
        )

        messageFlow.tryEmit(message)
        Timber.d("Оброблено лайки: $nickname - $likeCount")
    }
} 