package com.streamchat.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

@Singleton
class PreferencesManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private object PreferencesKeys {
        val AUTO_TRANSLATE = booleanPreferencesKey("auto_translate")
        val TARGET_LANGUAGE = stringPreferencesKey("target_language")
    }

    val autoTranslateEnabled: Flow<Boolean> = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                Timber.e(exception, "Помилка читання налаштувань")
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            preferences[PreferencesKeys.AUTO_TRANSLATE] ?: false
        }

    val targetLanguage: Flow<String> = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                Timber.e(exception, "Помилка читання налаштувань")
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            preferences[PreferencesKeys.TARGET_LANGUAGE] ?: "UK"
        }

    suspend fun setAutoTranslateEnabled(enabled: Boolean) {
        try {
            context.dataStore.edit { preferences ->
                preferences[PreferencesKeys.AUTO_TRANSLATE] = enabled
            }
        } catch (e: Exception) {
            Timber.e(e, "Помилка збереження налаштування auto_translate")
        }
    }

    suspend fun setTargetLanguage(language: String) {
        try {
            context.dataStore.edit { preferences ->
                preferences[PreferencesKeys.TARGET_LANGUAGE] = language
            }
        } catch (e: Exception) {
            Timber.e(e, "Помилка збереження налаштування target_language")
        }
    }
} 