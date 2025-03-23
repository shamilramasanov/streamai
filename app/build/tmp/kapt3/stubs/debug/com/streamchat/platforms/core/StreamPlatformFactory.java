package com.streamchat.platforms.core;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/streamchat/platforms/core/StreamPlatformFactory;", "", "youtubePlatform", "Lcom/streamchat/platforms/youtube/YouTubePlatform;", "tiktokPlatform", "Lcom/streamchat/platforms/tiktok/TikTokPlatform;", "(Lcom/streamchat/platforms/youtube/YouTubePlatform;Lcom/streamchat/platforms/tiktok/TikTokPlatform;)V", "createPlatform", "Lcom/streamchat/platforms/core/StreamPlatform;", "url", "", "detectPlatform", "Lcom/streamchat/platforms/core/PlatformType;", "isTikTokUrl", "", "isYouTubeUrl", "app_debug"})
public final class StreamPlatformFactory {
    @org.jetbrains.annotations.NotNull()
    private final com.streamchat.platforms.youtube.YouTubePlatform youtubePlatform = null;
    @org.jetbrains.annotations.NotNull()
    private final com.streamchat.platforms.tiktok.TikTokPlatform tiktokPlatform = null;
    
    @javax.inject.Inject()
    public StreamPlatformFactory(@org.jetbrains.annotations.NotNull()
    com.streamchat.platforms.youtube.YouTubePlatform youtubePlatform, @org.jetbrains.annotations.NotNull()
    com.streamchat.platforms.tiktok.TikTokPlatform tiktokPlatform) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.streamchat.platforms.core.StreamPlatform createPlatform(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.streamchat.platforms.core.PlatformType detectPlatform(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return null;
    }
    
    private final boolean isYouTubeUrl(java.lang.String url) {
        return false;
    }
    
    private final boolean isTikTokUrl(java.lang.String url) {
        return false;
    }
}