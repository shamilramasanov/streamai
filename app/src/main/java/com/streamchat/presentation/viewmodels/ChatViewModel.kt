package com.streamchat.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.streamchat.data.remote.YouTubeApiService
import com.streamchat.domain.model.ChatMessage
import com.streamchat.domain.model.MessageType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val youTubeApiService: YouTubeApiService
) : ViewModel() {
    
    private val _allMessages = MutableStateFlow<List<ChatMessage>>(emptyList())
    val allMessages: StateFlow<List<ChatMessage>> = _allMessages
    
    private val _questions = MutableStateFlow<List<ChatMessage>>(emptyList())
    val questions: StateFlow<List<ChatMessage>> = _questions
    
    private val _gratitude = MutableStateFlow<List<ChatMessage>>(emptyList())
    val gratitude: StateFlow<List<ChatMessage>> = _gratitude
    
    private val _negative = MutableStateFlow<List<ChatMessage>>(emptyList())
    val negative: StateFlow<List<ChatMessage>> = _negative
    
    private val _personalQuestions = MutableStateFlow<List<ChatMessage>>(emptyList())
    val personalQuestions: StateFlow<List<ChatMessage>> = _personalQuestions
    
    private val _chatMood = MutableStateFlow(0.0f)
    val chatMood: StateFlow<Float> = _chatMood
    
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading
    
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error
    
    private var currentVideoId: String? = null
    
    fun connectToChat(streamUrl: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _isLoading.value = true
                _error.value = null
                
                val videoId = youTubeApiService.extractVideoId(streamUrl)
                currentVideoId = videoId
                youTubeApiService.connectToLiveChat(videoId)
                startMessageProcessing()
                
                _isLoading.value = false
            } catch (e: Exception) {
                _isLoading.value = false
                Log.e("StreamChat", "❌ Помилка підключення до чату: ${e.message}", e)
                _error.value = e.message ?: "Невідома помилка"
            }
        }
    }
    
    private fun extractVideoId(url: String): String? {
        Log.v("StreamChat", "🔍 Спроба витягнути ID відео з URL: '$url'")
        val pattern = "(?:live/|v=|/)([a-zA-Z0-9_-]+)".toRegex()
        val result = pattern.find(url)?.groupValues?.get(1)
        Log.v("StreamChat", "🎯 Результат витягнення ID: '$result'")
        return result
    }
    
    private fun startMessageProcessing() {
        viewModelScope.launch {
            try {
                youTubeApiService.chatMessages.collect { message ->
                    Log.v("StreamChat", "📨 Отримано нове повідомлення: ${message.content}")
                    processMessage(message)
                }
            } catch (e: Exception) {
                Log.e("StreamChat", "❌ Помилка обробки повідомлень: ${e.message}", e)
                _error.value = "Помилка обробки повідомлень: ${e.message}"
            }
        }
    }
    
    private fun processMessage(message: ChatMessage) {
        viewModelScope.launch {
            try {
                val currentMessages = _allMessages.value.toMutableList()
                currentMessages.add(0, message)
                
                // Обмежуємо кількість повідомлень для оптимізації пам'яті
                if (currentMessages.size > 100) {
                    currentMessages.removeAt(currentMessages.size - 1)
                }
                
                _allMessages.value = currentMessages
                
                Log.v("StreamChat", "📝 Оновлено список повідомлень. Всього: ${currentMessages.size}")

                when {
                    isQuestion(message.content) -> {
                        _questions.value = _questions.value + message
                        Log.v("StreamChat", "❓ Додано нове питання")
                    }
                    isGratitude(message.content) -> {
                        _gratitude.value = _gratitude.value + message
                        updateChatMood(0.1f)
                        Log.v("StreamChat", "🙏 Додано нову подяку")
                    }
                    isNegative(message.content) -> {
                        _negative.value = _negative.value + message
                        updateChatMood(-0.1f)
                        Log.v("StreamChat", "😠 Додано негативне повідомлення")
                    }
                    isPersonalQuestion(message.content) -> {
                        _personalQuestions.value = _personalQuestions.value + message
                        Log.v("StreamChat", "👤 Додано персональне питання")
                    }
                }
            } catch (e: Exception) {
                Log.e("StreamChat", "❌ Помилка обробки повідомлення: ${e.message}", e)
            }
        }
    }
    
    private fun updateChatMood(delta: Float) {
        _chatMood.value = (_chatMood.value + delta).coerceIn(-1f, 1f)
    }
    
    private fun isQuestion(content: String): Boolean {
        return content.contains(Regex("[?]|що|як|чому|коли|де|хто|навіщо|чи|який", RegexOption.IGNORE_CASE))
    }
    
    private fun isPersonalQuestion(content: String): Boolean {
        return content.contains(Regex("@|згадав|згадала", RegexOption.IGNORE_CASE))
    }
    
    private fun isGratitude(content: String): Boolean {
        return content.contains(Regex("дякую|спасибі|дяк|красно|вдячний|вдячна", RegexOption.IGNORE_CASE))
    }
    
    private fun isNegative(content: String): Boolean {
        return content.contains(Regex("поганий|жахливо|жах|погано|негатив|зле|бридко", RegexOption.IGNORE_CASE))
    }
    
    override fun onCleared() {
        super.onCleared()
        viewModelScope.launch {
            currentVideoId?.let {
                youTubeApiService.disconnectFromLiveChat()
            }
        }
    }
} 