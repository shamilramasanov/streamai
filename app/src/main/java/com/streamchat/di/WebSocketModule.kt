package com.streamchat.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class WebSocketModule {
    // Видалено дублюючу прив'язку TikTokWebSocket
} 