package com.streamchat.platforms.tiktok;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00a2\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u000fH\u0096@\u00a2\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/streamchat/platforms/tiktok/TikTokWebSocketImpl;", "Lcom/streamchat/platforms/tiktok/TikTokWebSocket;", "()V", "client", "Lokhttp3/OkHttpClient;", "messageChannel", "Lkotlinx/coroutines/channels/Channel;", "Lcom/streamchat/platforms/tiktok/model/TikTokMessage;", "messages", "Lkotlinx/coroutines/flow/Flow;", "getMessages", "()Lkotlinx/coroutines/flow/Flow;", "webSocket", "Lokhttp3/WebSocket;", "connect", "", "username", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disconnect", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class TikTokWebSocketImpl implements com.streamchat.platforms.tiktok.TikTokWebSocket {
    @org.jetbrains.annotations.Nullable()
    private okhttp3.WebSocket webSocket;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.channels.Channel<com.streamchat.platforms.tiktok.model.TikTokMessage> messageChannel = null;
    @org.jetbrains.annotations.NotNull()
    private final okhttp3.OkHttpClient client = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.streamchat.platforms.tiktok.model.TikTokMessage> messages = null;
    
    @javax.inject.Inject()
    public TikTokWebSocketImpl() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.streamchat.platforms.tiktok.model.TikTokMessage> getMessages() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object connect(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object disconnect(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}