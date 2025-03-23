package com.streamchat.platforms.core

import com.streamchat.platforms.youtube.YouTubePlatform
import com.streamchat.platforms.tiktok.TikTokPlatform
import javax.inject.Inject
import javax.inject.Singleton
import timber.log.Timber

@Singleton
class StreamPlatformFactory @Inject constructor(
    private val youtubePlatform: YouTubePlatform,
    private val tiktokPlatform: TikTokPlatform
) {
    
    fun createPlatform(url: String): StreamPlatform {
        Timber.d("Creating platform for URL: $url")
        return when {
            isYouTubeUrl(url) -> {
                Timber.d("Creating YouTube platform")
                youtubePlatform
            }
            isTikTokUrl(url) -> {
                Timber.d("Creating TikTok platform")
                tiktokPlatform
            }
            else -> throw IllegalArgumentException("Unsupported platform URL")
        }
    }

    fun detectPlatform(url: String): PlatformType {
        return when {
            isYouTubeUrl(url) -> PlatformType.YOUTUBE
            isTikTokUrl(url) -> PlatformType.TIKTOK
            else -> throw IllegalArgumentException("Unknown platform URL")
        }
    }

    private fun isYouTubeUrl(url: String): Boolean {
        return url.contains("youtube.com") || url.contains("youtu.be")
    }

    private fun isTikTokUrl(url: String): Boolean {
        return url.contains("tiktok.com") || url.contains("vm.tiktok.com") || url.startsWith("@")
    }
} 