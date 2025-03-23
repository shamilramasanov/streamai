package com.streamchat.platforms.tiktok

import com.streamchat.platforms.tiktok.model.TikTokMessage
import com.streamchat.platforms.tiktok.model.MessageData
import com.streamchat.platforms.tiktok.model.TikTokUser
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import okhttp3.*
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton
import org.json.JSONObject
import java.util.concurrent.TimeUnit

@Singleton
class TikTokWebSocketImpl @Inject constructor() : TikTokWebSocket {
    private var webSocket: WebSocket? = null
    private val messageChannel = Channel<TikTokMessage>(Channel.UNLIMITED)
    private val client = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .build()

    override val messages: Flow<TikTokMessage> = messageChannel.receiveAsFlow()

    override suspend fun connect(username: String) {
        try {
            Timber.d("🔄 Підключення до TikTok Live для користувача: $username")
            
            val request = Request.Builder()
                .url("wss://tiktok-chat-proxy.zerody.one/live/$username")
                .build()

            Timber.d("📡 Створюємо WebSocket з'єднання з URL: ${request.url}")

            webSocket = client.newWebSocket(request, object : WebSocketListener() {
                override fun onOpen(webSocket: WebSocket, response: Response) {
                    Timber.d("✅ WebSocket з'єднання відкрито. Код відповіді: ${response.code}")
                }

                override fun onMessage(webSocket: WebSocket, text: String) {
                    try {
                        Timber.d("📨 Отримано повідомлення: $text")
                        val json = JSONObject(text)
                        when (json.getString("type")) {
                            "chat" -> {
                                val data = json.getJSONObject("data")
                                val user = data.getJSONObject("user")
                                val message = TikTokMessage(
                                    type = "chat",
                                    data = MessageData(
                                        user = TikTokUser(
                                            userId = user.getString("userId"),
                                            nickname = user.getString("nickname"),
                                            profilePicture = user.optString("profilePicture")
                                        ),
                                        content = data.getString("content")
                                    )
                                )
                                messageChannel.trySend(message)
                                Timber.d("💬 Оброблено чат повідомлення від ${user.getString("nickname")}")
                            }
                            "gift" -> {
                                val data = json.getJSONObject("data")
                                val user = data.getJSONObject("user")
                                val message = TikTokMessage(
                                    type = "gift",
                                    data = MessageData(
                                        user = TikTokUser(
                                            userId = user.getString("userId"),
                                            nickname = user.getString("nickname"),
                                            profilePicture = user.optString("profilePicture")
                                        ),
                                        giftName = data.getString("giftName"),
                                        giftValue = data.getInt("diamondCount")
                                    )
                                )
                                messageChannel.trySend(message)
                                Timber.d("🎁 Оброблено подарунок від ${user.getString("nickname")}")
                            }
                            "like" -> {
                                val data = json.getJSONObject("data")
                                val user = data.getJSONObject("user")
                                val message = TikTokMessage(
                                    type = "like",
                                    data = MessageData(
                                        user = TikTokUser(
                                            userId = user.getString("userId"),
                                            nickname = user.getString("nickname"),
                                            profilePicture = user.optString("profilePicture")
                                        ),
                                        likeCount = data.getInt("likeCount")
                                    )
                                )
                                messageChannel.trySend(message)
                                Timber.d("❤️ Оброблено лайки від ${user.getString("nickname")}")
                            }
                            else -> {
                                Timber.d("ℹ️ Отримано невідомий тип повідомлення: ${json.getString("type")}")
                            }
                        }
                    } catch (e: Exception) {
                        Timber.e(e, "❌ Помилка обробки повідомлення: $text")
                    }
                }

                override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                    Timber.e(t, "❌ Помилка WebSocket з'єднання. Код відповіді: ${response?.code}")
                }

                override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
                    Timber.d("🔒 WebSocket з'єднання закрито. Код: $code, причина: $reason")
                }

                override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
                    Timber.d("⚠️ WebSocket з'єднання закривається. Код: $code, причина: $reason")
                }
            })
        } catch (e: Exception) {
            Timber.e(e, "❌ Не вдалося підключитися до TikTok Live")
            throw e
        }
    }

    override suspend fun disconnect() {
        try {
            Timber.d("🔄 Відключення від TikTok Live")
            webSocket?.close(1000, "Користувач відключився")
            webSocket = null
            messageChannel.close()
            Timber.d("✅ Успішно відключено від TikTok Live")
        } catch (e: Exception) {
            Timber.e(e, "❌ Помилка при відключенні від TikTok Live")
            throw e
        }
    }
} 