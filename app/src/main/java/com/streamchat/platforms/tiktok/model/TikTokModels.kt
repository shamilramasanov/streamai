package com.streamchat.platforms.tiktok.model

data class TikTokMessage(
    val type: String,
    val data: MessageData
)

data class MessageData(
    val user: TikTokUser,
    val content: String? = null,
    val giftName: String? = null,
    val giftValue: Int? = null,
    val likeCount: Int? = null
)

data class TikTokUser(
    val userId: String,
    val nickname: String,
    val profilePicture: String? = null
) 