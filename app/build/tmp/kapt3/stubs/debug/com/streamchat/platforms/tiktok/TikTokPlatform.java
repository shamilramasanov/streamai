package com.streamchat.platforms.tiktok;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@\u00a2\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\rH\u0096@\u00a2\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/streamchat/platforms/tiktok/TikTokPlatform;", "Lcom/streamchat/platforms/core/StreamPlatform;", "client", "Lokhttp3/OkHttpClient;", "(Lokhttp3/OkHttpClient;)V", "messageFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/streamchat/platforms/core/StreamMessage;", "usernameRegex", "Lkotlin/text/Regex;", "webSocket", "Lokhttp3/WebSocket;", "connect", "", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disconnect", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractUsername", "getMessages", "Lkotlinx/coroutines/flow/Flow;", "handleChatMessage", "data", "Lorg/json/JSONObject;", "handleGiftMessage", "handleLikeMessage", "isValidUrl", "", "app_debug"})
public final class TikTokPlatform implements com.streamchat.platforms.core.StreamPlatform {
    @org.jetbrains.annotations.NotNull()
    private final okhttp3.OkHttpClient client = null;
    @org.jetbrains.annotations.Nullable()
    private okhttp3.WebSocket webSocket;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.text.Regex usernameRegex = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.streamchat.platforms.core.StreamMessage> messageFlow = null;
    
    @javax.inject.Inject()
    public TikTokPlatform(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient client) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object connect(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object disconnect(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.streamchat.platforms.core.StreamMessage> getMessages() {
        return null;
    }
    
    @java.lang.Override()
    public boolean isValidUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return false;
    }
    
    private final java.lang.String extractUsername(java.lang.String url) {
        return null;
    }
    
    private final void handleChatMessage(org.json.JSONObject data) {
    }
    
    private final void handleGiftMessage(org.json.JSONObject data) {
    }
    
    private final void handleLikeMessage(org.json.JSONObject data) {
    }
}