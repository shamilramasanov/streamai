package com.streamchat.translation

import android.content.Context
import com.streamchat.R
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeepLTranslationService @Inject constructor(
    @ApplicationContext private val context: Context,
    private val client: OkHttpClient,
    private val cache: TranslationCache
) : TranslationService {
    
    private val apiKey = context.getString(R.string.deepl_api_key)
    private val baseUrl = "https://api-free.deepl.com/v2"
    
    override suspend fun translate(text: String, targetLang: String): String {
        return translateBatch(listOf(text), targetLang).first()
    }
    
    override suspend fun translateBatch(texts: List<String>, targetLang: String): List<String> {
        // Фільтруємо тексти, які вже є в кеші
        val uncachedTexts = texts.filter { text -> 
            cache.getCachedTranslation(text, targetLang) == null 
        }
        
        if (uncachedTexts.isEmpty()) {
            Timber.d("Всі переклади знайдено в кеші")
            return texts.map { text -> 
                cache.getCachedTranslation(text, targetLang) ?: text 
            }
        }

        return withContext(Dispatchers.IO) {
            try {
                val formBody = buildString {
                    uncachedTexts.forEachIndexed { index, text ->
                        if (index > 0) append("&")
                        append("text=").append(text)
                    }
                    append("&target_lang=").append(targetLang)
                }

                val request = Request.Builder()
                    .url("$baseUrl/translate")
                    .addHeader("Authorization", "DeepL-Auth-Key $apiKey")
                    .post(formBody.toRequestBody("application/x-www-form-urlencoded".toMediaType()))
                    .build()

                client.newCall(request).execute().use { response ->
                    if (!response.isSuccessful) {
                        Timber.e("Помилка batch перекладу: ${response.code} - ${response.body?.string()}")
                        throw Exception("Batch translation failed with code: ${response.code}")
                    }
                    
                    val jsonResponse = JSONObject(response.body?.string() ?: "")
                    val translations = jsonResponse.getJSONArray("translations")
                    
                    // Зберігаємо нові переклади в кеш
                    uncachedTexts.forEachIndexed { index, text ->
                        val translation = translations.getJSONObject(index).getString("text")
                        cache.cacheTranslation(text, targetLang, translation)
                        Timber.d("Кешовано переклад: $text -> $translation")
                    }
                    
                    // Повертаємо всі переклади (з кешу + нові)
                    texts.map { text ->
                        cache.getCachedTranslation(text, targetLang) ?: text
                    }
                }
            } catch (e: Exception) {
                Timber.e(e, "Помилка при batch перекладі")
                throw e
            }
        }
    }
    
    override fun isTranslationNeeded(text: String, targetLang: String): Boolean {
        // Проста перевірка на наявність не-ASCII символів
        return text.any { it.code > 127 }
    }
    
    override fun detectLanguage(text: String): String {
        // Спрощена версія - припускаємо, що текст англійською
        return "EN"
    }
} 