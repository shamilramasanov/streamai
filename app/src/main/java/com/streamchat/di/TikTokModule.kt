package com.streamchat.di

import com.streamchat.platforms.tiktok.TikTokWebSocket
import com.streamchat.platforms.tiktok.TikTokWebSocketImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class TikTokModule {
    
    @Binds
    @Singleton
    abstract fun bindTikTokWebSocket(
        impl: TikTokWebSocketImpl
    ): TikTokWebSocket
} 