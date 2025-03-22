package com.streamchat.di

import android.util.Log
import com.streamchat.data.remote.YouTubeApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    
    @Provides
    @Singleton
    fun provideYouTubeApiService(): YouTubeApiService {
        println("🏭 AppModule: Створення YouTubeApiService")
        Log.e("StreamChat", "🏭 AppModule: Створення YouTubeApiService")
        
        return YouTubeApiService().also {
            println("✅ AppModule: YouTubeApiService успішно створено")
            Log.e("StreamChat", "✅ AppModule: YouTubeApiService успішно створено")
        }
    }
} 