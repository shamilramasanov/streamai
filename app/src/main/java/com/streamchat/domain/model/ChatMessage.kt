package com.streamchat.domain.model

data class ChatMessage(
    val id: String,
    val authorName: String,
    val content: String,
    val timestamp: Long,
    val messageType: MessageType
) 