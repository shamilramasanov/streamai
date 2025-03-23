package com.streamchat.platforms.tiktok

import com.streamchat.platforms.tiktok.model.TikTokMessage
import kotlinx.coroutines.flow.Flow

interface TikTokWebSocket {
    val messages: Flow<TikTokMessage>
    
    suspend fun connect(username: String)
    suspend fun disconnect()
} 