package com.streamchat.domain.repository

import com.streamchat.data.remote.YouTubeApiService
import com.streamchat.domain.model.ChatMessage
import com.streamchat.domain.model.MessageType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

interface ChatRepository {
    suspend fun connectToChat(streamUrl: String): Result<Unit>
    suspend fun disconnectFromChat()
    fun getChatMessages(): Flow<List<ChatMessage>>
    fun getConnectionState(): Flow<Boolean>
}

@Singleton
class ChatRepositoryImpl @Inject constructor(
    private val youTubeApiService: YouTubeApiService
) : ChatRepository {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val _messages = MutableStateFlow<List<ChatMessage>>(emptyList())
    private val _isConnected = MutableStateFlow(false)
    
    init {
        scope.launch {
            youTubeApiService.messages.collect { dtoMessages ->
                _messages.value = dtoMessages.map { dto ->
                    ChatMessage(
                        id = dto.id,
                        authorName = dto.authorName,
                        content = dto.content,
                        timestamp = System.currentTimeMillis(),
                        messageType = determineMessageType(dto.content)
                    )
                }
            }
        }
    }
    
    override suspend fun connectToChat(streamUrl: String): Result<Unit> {
        return try {
            if (!youTubeApiService.isValidYouTubeUrl(streamUrl)) {
                return Result.failure(IllegalArgumentException("Невірна URL-адреса YouTube"))
            }

            val videoId = youTubeApiService.extractVideoId(streamUrl)
            if (videoId == null) {
                return Result.failure(IllegalArgumentException("Не вдалося отримати ID відео"))
            }

            youTubeApiService.connectToLiveChat(videoId)
            _isConnected.value = true
            Result.success(Unit)
        } catch (e: Exception) {
            _isConnected.value = false
            Result.failure(e)
        }
    }

    override suspend fun disconnectFromChat() {
        try {
            youTubeApiService.disconnectFromLiveChat()
        } finally {
            _isConnected.value = false
        }
    }

    override fun getChatMessages(): Flow<List<ChatMessage>> = _messages.asStateFlow()
    
    override fun getConnectionState(): Flow<Boolean> = _isConnected.asStateFlow()
    
    private fun determineMessageType(content: String): MessageType {
        return when {
            content.contains("?") -> MessageType.QUESTION
            content.contains("дякую", ignoreCase = true) || 
            content.contains("спасибі", ignoreCase = true) -> MessageType.GRATITUDE
            content.contains("ти", ignoreCase = true) || 
            content.contains("ви", ignoreCase = true) -> MessageType.PERSONAL_QUESTION
            content.contains("ні", ignoreCase = true) || 
            content.contains("не", ignoreCase = true) -> MessageType.NEGATIVE
            else -> MessageType.REGULAR
        }
    }
} 