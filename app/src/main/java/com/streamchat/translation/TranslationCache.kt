package com.streamchat.translation

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TranslationCache @Inject constructor() {
    private val cache = mutableMapOf<String, String>()
    
    fun getCachedTranslation(text: String, targetLang: String): String? {
        return cache["${text}_$targetLang"]
    }
    
    fun cacheTranslation(text: String, targetLang: String, translation: String) {
        cache["${text}_$targetLang"] = translation
    }
    
    fun clear() {
        cache.clear()
    }
} 