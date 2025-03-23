package com.streamchat

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class StreamChatApp : Application() {
    
    override fun onCreate() {
        super.onCreate()
        
        println("🚀 StreamChatApp.onCreate()")
        Log.e("StreamChat", "🚀 StreamChatApp.onCreate()")
        Log.wtf("StreamChat", "🚀 StreamChatApp.onCreate()")
        
        try {
            // Перевірка наявності API ключа
            val apiKey = com.streamchat.core.Constants.YOUTUBE_API_KEY
            println("🔑 API ключ: $apiKey")
            Log.e("StreamChat", "🔑 API ключ: $apiKey")
            
            // Перевірка наявності назви додатку
            val appName = com.streamchat.core.Constants.APPLICATION_NAME
            println("📱 Назва додатку: $appName")
            Log.e("StreamChat", "📱 Назва додатку: $appName")
            
        } catch (e: Exception) {
            println("❌ Помилка ініціалізації додатку: ${e.message}")
            Log.e("StreamChat", "❌ Помилка ініціалізації додатку: ${e.message}")
            Log.e("StreamChat", "❌ Стек помилки: ${e.stackTraceToString()}")
        }

        // Ініціалізуємо Timber тільки в Debug режимі
        if (packageManager.getApplicationInfo(packageName, 0).flags and android.content.pm.ApplicationInfo.FLAG_DEBUGGABLE != 0) {
            Timber.plant(Timber.DebugTree())
        }
    }
} 