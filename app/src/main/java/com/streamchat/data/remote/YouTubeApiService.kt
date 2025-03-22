package com.streamchat.data.remote

import android.util.Log
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
import com.google.api.client.json.gson.GsonFactory
import com.google.api.services.youtube.YouTube
import com.streamchat.core.Constants
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject
import javax.inject.Singleton
import java.util.regex.Pattern
import com.streamchat.domain.model.ChatMessage
import com.streamchat.domain.model.MessageType

@Singleton
class YouTubeApiService @Inject constructor() {
    companion object {
        private const val TAG = Constants.LOG_TAG
    }

    init {
        println("🚀 YouTubeApiService: Створення екземпляру")
        Log.v(TAG, "🚀 YouTubeApiService: Створення екземпляру")
        Log.d(TAG, "🚀 YouTubeApiService: Створення екземпляру")
        Log.i(TAG, "🚀 YouTubeApiService: Створення екземпляру")
        Log.e(TAG, "🚀 YouTubeApiService: Створення екземпляру")
        
        try {
            initializeYouTubeClient()
        } catch (e: Exception) {
            println("❌ YouTubeApiService: Помилка ініціалізації: ${e.message}")
            Log.v(TAG, "❌ YouTubeApiService: Помилка ініціалізації: ${e.message}")
            Log.e(TAG, "❌ YouTubeApiService: Помилка ініціалізації: ${e.message}")
            Log.e(TAG, "❌ Стек помилки: ${e.stackTraceToString()}")
        }
    }

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private var chatPollingJob: Job? = null
    private val _messages = MutableStateFlow<List<ChatMessageDto>>(emptyList())
    val messages = _messages.asStateFlow()
    
    private var youtube: YouTube? = null
    private var retryCount = 0
    
    private val _chatMessages = MutableSharedFlow<ChatMessage>()
    val chatMessages: SharedFlow<ChatMessage> = _chatMessages

    private fun initializeYouTubeClient() {
        println("🚀 YouTubeApiService: Початок ініціалізації клієнта")
        Log.v(TAG, "🚀 YouTubeApiService: Початок ініціалізації клієнта")
        Log.d(TAG, "🚀 YouTubeApiService: Початок ініціалізації клієнта")
        Log.i(TAG, "🚀 YouTubeApiService: Початок ініціалізації клієнта")
        Log.e(TAG, "🚀 YouTubeApiService: Початок ініціалізації клієнта")
        
        try {
            println("🔑 Використовую API ключ: ${Constants.YOUTUBE_API_KEY}")
            Log.v(TAG, "🔑 Використовую API ключ: ${Constants.YOUTUBE_API_KEY}")
            Log.d(TAG, "🔑 Використовую API ключ: ${Constants.YOUTUBE_API_KEY}")
            
            youtube = YouTube.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                GsonFactory.getDefaultInstance(),
                null
            )
                .setApplicationName(Constants.APPLICATION_NAME)
                .build()
                .also { 
                    println("✅ YouTubeApiService: Клієнт успішно створено")
                    Log.v(TAG, "✅ YouTubeApiService: Клієнт успішно створено")
                    Log.d(TAG, "✅ YouTubeApiService: Клієнт успішно створено")
                    Log.i(TAG, "✅ YouTubeApiService: Клієнт успішно створено")
                    retryCount = 0
                }
        } catch (e: Exception) {
            retryCount++
            println("❌ YouTubeApiService: Помилка створення клієнта (спроба $retryCount): ${e.message}")
            Log.v(TAG, "❌ YouTubeApiService: Помилка створення клієнта (спроба $retryCount): ${e.message}")
            Log.e(TAG, "❌ YouTubeApiService: Помилка створення клієнта (спроба $retryCount): ${e.message}")
            Log.e(TAG, "❌ Стек помилки: ${e.stackTraceToString()}")
            
            if (retryCount < Constants.MAX_RETRIES) {
                println("🔄 YouTubeApiService: Повторна спроба через 1 секунду...")
                Log.v(TAG, "🔄 YouTubeApiService: Повторна спроба через 1 секунду...")
                Log.i(TAG, "🔄 YouTubeApiService: Повторна спроба через 1 секунду...")
                Thread.sleep(1000)
                initializeYouTubeClient()
            } else {
                throw e
            }
        }
    }

    fun extractVideoId(url: String): String {
        Log.v("StreamChat", "🔍 Спроба витягнути ID відео з URL: '$url'")
        
        val patterns = listOf(
            "(?<=live/)([\\w-]+)".toRegex(),
            "(?<=v=)([\\w-]+)".toRegex(),
            "(?<=youtu.be/)([\\w-]+)".toRegex(),
            "(?<=embed/)([\\w-]+)".toRegex()
        )
        
        for (pattern in patterns) {
            pattern.find(url)?.value?.let { id ->
                Log.v("StreamChat", "🎯 Знайдено ID: '$id' за допомогою патерну: $pattern")
                return id
            }
        }
        
        Log.e("StreamChat", "❌ Не вдалося витягнути ID відео з URL: '$url'")
        throw IllegalArgumentException("Неправильний формат URL відео")
    }

    fun isValidYouTubeUrl(url: String): Boolean {
        val isValid = url.contains("youtube.com") || url.contains("youtu.be")
        println("🔍 Перевірка URL '$url': ${if (isValid) "✅ валідний" else "❌ невалідний"}")
        Log.e(TAG, "🔍 Перевірка URL '$url': ${if (isValid) "✅ валідний" else "❌ невалідний"}")
        return isValid
    }

    suspend fun connectToLiveChat(videoId: String) {
        try {
            println("🔄 Початок підключення до чату для відео ID: $videoId")
            Log.e(TAG, "🔄 Початок підключення до чату для відео ID: $videoId")
            
            if (youtube == null) {
                println("❌ YouTube клієнт не ініціалізовано")
                Log.e(TAG, "❌ YouTube клієнт не ініціалізовано")
                initializeYouTubeClient()
            }
            
            val liveChatId = getLiveChatId(videoId)
            if (liveChatId == null) {
                val error = "❌ Не вдалося отримати ID чату для відео $videoId"
                println(error)
                Log.e(TAG, error)
                throw IllegalStateException(error)
            }
            
            println("✅ Отримано ID чату: $liveChatId")
            Log.e(TAG, "✅ Отримано ID чату: $liveChatId")
            startChatPolling(liveChatId)
            
        } catch (e: Exception) {
            println("❌ Помилка підключення до чату: ${e.message}")
            Log.e(TAG, "❌ Помилка підключення до чату: ${e.message}")
            Log.e(TAG, "❌ Стек помилки: ${e.stackTraceToString()}")
            throw e
        }
    }

    private suspend fun getLiveChatId(videoId: String): String? {
        return try {
            println("🔄 Запит ID чату для відео: $videoId")
            Log.e(TAG, "🔄 Запит ID чату для відео: $videoId")
            
            val request = youtube?.videos()
                ?.list(listOf("liveStreamingDetails"))
                ?.setKey(Constants.YOUTUBE_API_KEY)
                ?.setId(listOf(videoId))
                
            if (request == null) {
                println("❌ YouTube клієнт не готовий")
                Log.e(TAG, "❌ YouTube клієнт не готовий")
                return null
            }
            
            println("📡 Виконання запиту до YouTube API...")
            Log.e(TAG, "📡 Виконання запиту до YouTube API...")
            val response = request.execute()
            println("📝 Отримано відповідь: ${response.toPrettyString()}")
            Log.e(TAG, "📝 Отримано відповідь: ${response.toPrettyString()}")

            val chatId = response.items?.firstOrNull()?.liveStreamingDetails?.activeLiveChatId
            if (chatId == null) {
                println("❌ Чат ID не знайдено у відповіді API")
                Log.e(TAG, "❌ Чат ID не знайдено у відповіді API")
                println("📝 Деталі відповіді: ${response.toPrettyString()}")
                Log.e(TAG, "📝 Деталі відповіді: ${response.toPrettyString()}")
            } else {
                println("✅ Успішно отримано ID чату: $chatId")
                Log.e(TAG, "✅ Успішно отримано ID чату: $chatId")
            }
            chatId
            
        } catch (e: Exception) {
            println("❌ Помилка отримання ID чату: ${e.message}")
            Log.e(TAG, "❌ Помилка отримання ID чату: ${e.message}")
            Log.e(TAG, "❌ Стек помилки: ${e.stackTraceToString()}")
            null
        }
    }

    private fun startChatPolling(liveChatId: String) {
        Log.e(TAG, "🔄 Запуск опитування чату для ID: $liveChatId")
        chatPollingJob?.cancel()
        
        chatPollingJob = scope.launch {
            var nextPageToken: String? = null
            
            while (isActive) {
                try {
                    val response = getLiveChatMessages(liveChatId, nextPageToken)
                    Log.e(TAG, "📝 Отримано ${response.messages.size} повідомлень")
                    
                    response.messages.forEach { messageDto ->
                        _chatMessages.emit(ChatMessage(
                            id = messageDto.id,
                            authorName = messageDto.authorName,
                            content = messageDto.content,
                            timestamp = messageDto.timestamp,
                            messageType = MessageType.REGULAR
                        ))
                    }
                    
                    nextPageToken = response.nextPageToken
                    Log.e(TAG, "⏱️ Наступне опитування через ${response.pollingIntervalMillis}мс")
                    delay(response.pollingIntervalMillis)
                    
                } catch (e: Exception) {
                    Log.e(TAG, "❌ Помилка при опитуванні чату: ${e.message}")
                    Log.e(TAG, "❌ Стек помилки: ${e.stackTraceToString()}")
                    delay(5000)
                }
            }
        }
    }

    private suspend fun getLiveChatMessages(liveChatId: String, pageToken: String? = null): LiveChatMessagesResponse {
        return try {
            Log.e(TAG, "🔄 Запит повідомлень чату для ID: $liveChatId")
            if (pageToken != null) {
                Log.e(TAG, "📄 Використовується pageToken: $pageToken")
            }
            
            val request = youtube?.liveChatMessages()
                ?.list(liveChatId, listOf("snippet", "authorDetails"))
                ?.setKey(Constants.YOUTUBE_API_KEY)
                ?.setMaxResults(200L)
                ?.apply { 
                    if (pageToken != null) {
                        this.pageToken = pageToken
                    }
                }

            if (request == null) {
                Log.e(TAG, "❌ YouTube клієнт не готовий")
                return LiveChatMessagesResponse(emptyList(), null, 5000)
            }
            
            Log.e(TAG, "📡 Виконання запиту повідомлень...")
            val response = request.execute()
            Log.e(TAG, "📝 Отримано відповідь: ${response.toPrettyString()}")

            LiveChatMessagesResponse(
                messages = response.items?.map { item ->
                    ChatMessageDto(
                        id = item.id,
                        authorName = item.authorDetails.displayName,
                        content = item.snippet.displayMessage,
                        timestamp = System.currentTimeMillis(),
                        messageType = MessageType.REGULAR
                    )
                } ?: emptyList(),
                nextPageToken = response.nextPageToken,
                pollingIntervalMillis = response.pollingIntervalMillis
            )
        } catch (e: Exception) {
            Log.e(TAG, "❌ Помилка отримання повідомлень чату: ${e.message}")
            Log.e(TAG, "❌ Стек помилки: ${e.stackTraceToString()}")
            LiveChatMessagesResponse(emptyList(), null, 5000)
        }
    }

    suspend fun disconnectFromLiveChat() {
        Log.e(TAG, "🔄 Відключення від чату")
        chatPollingJob?.cancel()
        chatPollingJob = null
        _messages.value = emptyList()
    }
}

data class LiveChatMessagesResponse(
    val messages: List<ChatMessageDto>,
    val nextPageToken: String?,
    val pollingIntervalMillis: Long
)

data class ChatMessageDto(
    val id: String,
    val authorName: String,
    val content: String,
    val timestamp: Long,
    val messageType: MessageType
) 