package com.streamchat.platforms.core

import kotlinx.coroutines.flow.Flow

interface StreamPlatform {
    suspend fun connect(url: String)
    suspend fun disconnect()
    fun getMessages(): Flow<StreamMessage>
    fun isValidUrl(url: String): Boolean
}

data class StreamMessage(
    val id: String,
    val text: String,
    val author: String,
    val timestamp: Long,
    val platform: PlatformType,
    val type: MessageType,
    val originalText: String? = null,
    val isTranslated: Boolean = false,
    val gifts: List<Gift>? = null,
    val likes: Int? = null
)

data class Gift(
    val name: String,
    val value: Int,
    val imageUrl: String? = null
)

enum class MessageType {
    REGULAR,
    QUESTION,
    PERSONAL_QUESTION,
    GRATITUDE,
    GIFT,
    SYSTEM
}

enum class PlatformType {
    YOUTUBE,
    TIKTOK,
    UNKNOWN
} 