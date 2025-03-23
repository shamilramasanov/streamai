package com.streamchat.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.streamchat.platforms.core.*
import com.streamchat.preferences.PreferencesManager
import com.streamchat.translation.TranslationService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

data class HomeStats(
    val totalMessages: Int = 0,
    val platformCounts: Map<PlatformType, Int> = emptyMap()
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val platformFactory: StreamPlatformFactory,
    private val translationService: TranslationService,
    private val preferencesManager: PreferencesManager
) : ViewModel() {

    private var _messages = MutableStateFlow<List<StreamMessage>>(emptyList())
    val messages: StateFlow<List<StreamMessage>> = _messages.asStateFlow()

    val isAutoTranslateEnabled: StateFlow<Boolean> = preferencesManager.autoTranslateEnabled
        .stateIn(viewModelScope, SharingStarted.Eagerly, false)

    val targetLanguage: StateFlow<String> = preferencesManager.targetLanguage
        .stateIn(viewModelScope, SharingStarted.Eagerly, "UK")

    private val _connectionState = MutableStateFlow<ConnectionState>(ConnectionState.Disconnected)
    val connectionState: StateFlow<ConnectionState> = _connectionState.asStateFlow()

    private val _translationState = MutableStateFlow<TranslationState>(TranslationState.Idle)
    val translationState: StateFlow<TranslationState> = _translationState.asStateFlow()

    private var currentPlatform: StreamPlatform? = null

    private val _stats = MutableStateFlow<Map<PlatformType, Int>>(emptyMap())
    val stats = _stats.asStateFlow()

    private val _selectedPlatform = MutableStateFlow<PlatformType?>(null)
    val selectedPlatform = _selectedPlatform.asStateFlow()

    private val _selectedMessageType = MutableStateFlow(MessageType.REGULAR)
    val selectedMessageType = _selectedMessageType.asStateFlow()

    private val _isAutomaticTranslationEnabled = MutableStateFlow(false)
    val isAutomaticTranslationEnabled = _isAutomaticTranslationEnabled.asStateFlow()

    init {
        viewModelScope.launch {
            combine(
                isAutoTranslateEnabled,
                targetLanguage
            ) { autoTranslate, language ->
                AutoTranslateConfig(autoTranslate, language)
            }.collect { config ->
                if (config.enabled) {
                    translateExistingMessages()
                }
            }
        }
    }

    fun detectPlatform(url: String): PlatformType {
        return when {
            url.contains("youtube", ignoreCase = true) -> PlatformType.YOUTUBE
            url.contains("tiktok", ignoreCase = true) -> PlatformType.TIKTOK
            else -> PlatformType.UNKNOWN
        }
    }

    fun connect(url: String) {
        viewModelScope.launch {
            try {
                // Визначаємо платформу за URL
                val platform = when {
                    url.contains("youtube") -> PlatformType.YOUTUBE
                    url.contains("tiktok") -> PlatformType.TIKTOK
                    else -> PlatformType.UNKNOWN
                }
                
                Timber.d("Підключення до $platform з URL: $url")
                
                // Отримуємо відповідний StreamPlatform
                val streamPlatform = platformFactory.createPlatform(url)
                
                if (streamPlatform == null) {
                    Timber.e("Платформу не знайдено для $platform")
                    return@launch
                }
                
                // Перевіряємо чи валідний URL
                if (!streamPlatform.isValidUrl(url)) {
                    Timber.e("Невалідний URL для $platform: $url")
                    return@launch
                }
                
                // Підключаємося
                streamPlatform.connect(url)
                
                // Оновлюємо стан
                currentPlatform = streamPlatform
                _selectedPlatform.value = platform
                
                // Починаємо збирати повідомлення
                streamPlatform.getMessages()
                    .onEach { message ->
                        processNewMessage(message)
                    }
                    .catch { e ->
                        Timber.e(e, "Помилка при отриманні повідомлень")
                    }
                    .launchIn(viewModelScope)
                
                Timber.d("Успішно підключено до $platform")
            } catch (e: Exception) {
                Timber.e(e, "Помилка при підключенні")
            }
        }
    }

    fun disconnect() {
        viewModelScope.launch {
            try {
                currentPlatform?.disconnect()
                _selectedPlatform.value = null
                _messages.value = emptyList()
                _stats.value = emptyMap()
                _connectionState.value = ConnectionState.Disconnected
                Timber.d("Відключено")
            } catch (e: Exception) {
                Timber.e(e, "Помилка при відключенні")
                _connectionState.value = ConnectionState.Error(e.message ?: "Невідома помилка")
            }
        }
    }

    private fun processNewMessage(message: StreamMessage) {
        viewModelScope.launch {
            _messages.value = (_messages.value + message).takeLast(100) // Обмежуємо до 100 повідомлень
            
            // Оновлюємо статистику
            val currentStats = _stats.value.toMutableMap()
            currentStats[message.platform] = (currentStats[message.platform] ?: 0) + 1
            _stats.value = currentStats
            
            // Автоматичний переклад, якщо ввімкнено
            if (_isAutomaticTranslationEnabled.value) {
                translateMessage(message)
            }
        }
    }

    fun selectMessageType(type: MessageType) {
        _selectedMessageType.value = type
    }

    fun translateMessage(message: StreamMessage) {
        viewModelScope.launch {
            try {
                if (message.isTranslated) return@launch
                
                val translation = translationService.translate(message.text, targetLanguage.value)
                val updatedMessage = message.copy(
                    text = translation,
                    originalText = message.text,
                    isTranslated = true
                )
                
                _messages.value = _messages.value.map {
                    if (it.id == message.id) updatedMessage else it
                }
            } catch (e: Exception) {
                Timber.e(e, "Помилка при перекладі повідомлення")
            }
        }
    }

    fun toggleAutomaticTranslation() {
        _isAutomaticTranslationEnabled.value = !_isAutomaticTranslationEnabled.value
    }

    private fun translateExistingMessages() {
        viewModelScope.launch {
            try {
                _translationState.value = TranslationState.Translating
                
                val textsToTranslate = _messages.value
                    .filter { msg -> 
                        !msg.isTranslated && 
                        translationService.isTranslationNeeded(msg.text, targetLanguage.value)
                    }
                    .map { it.text }
                
                if (textsToTranslate.isEmpty()) {
                    _translationState.value = TranslationState.Idle
                    return@launch
                }
                
                val translatedTexts = translationService.translateBatch(
                    textsToTranslate, 
                    targetLanguage.value
                )
                
                val translationMap = textsToTranslate.zip(translatedTexts).toMap()
                
                _messages.value = _messages.value.map { msg ->
                    if (translationMap.containsKey(msg.text)) {
                        msg.copy(
                            text = translationMap[msg.text] ?: msg.text,
                            originalText = msg.text,
                            isTranslated = true
                        )
                    } else {
                        msg
                    }
                }
                
                _translationState.value = TranslationState.Idle
            } catch (e: Exception) {
                Timber.e(e, "Помилка при перекладі повідомлень")
                _translationState.value = TranslationState.Error(e.message ?: "Помилка перекладу")
            }
        }
    }

    fun toggleAutoTranslate() {
        viewModelScope.launch {
            val newValue = !isAutoTranslateEnabled.value
            preferencesManager.setAutoTranslateEnabled(newValue)
        }
    }
    
    fun setTargetLanguage(lang: String) {
        viewModelScope.launch {
            preferencesManager.setTargetLanguage(lang)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.launch {
            disconnect()
        }
    }
}

sealed class ConnectionState {
    object Connected : ConnectionState()
    object Connecting : ConnectionState()
    object Disconnected : ConnectionState()
    data class Error(val message: String) : ConnectionState()
}

sealed class TranslationState {
    object Idle : TranslationState()
    object Translating : TranslationState()
    data class Error(val message: String) : TranslationState()
}

private data class AutoTranslateConfig(
    val enabled: Boolean,
    val language: String
) 