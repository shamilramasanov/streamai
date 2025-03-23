package com.streamchat.translation

import kotlinx.coroutines.flow.Flow

interface TranslationService {
    suspend fun translate(text: String, targetLang: String): String
    suspend fun translateBatch(texts: List<String>, targetLang: String): List<String>
    fun isTranslationNeeded(text: String, targetLang: String): Boolean
    fun detectLanguage(text: String): String
} 