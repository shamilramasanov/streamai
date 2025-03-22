package com.streamchat.data.remote;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0086@\u00a2\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020\u001bH\u0086@\u00a2\u0006\u0002\u0010 J\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001dJ\u0018\u0010#\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001c\u001a\u00020\u001dH\u0082@\u00a2\u0006\u0002\u0010\u001eJ\"\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001d2\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010\u001dH\u0082@\u00a2\u0006\u0002\u0010(J\b\u0010)\u001a\u00020\u001bH\u0002J\u000e\u0010*\u001a\u00020+2\u0006\u0010\"\u001a\u00020\u001dJ\u0010\u0010,\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u001dH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/streamchat/data/remote/YouTubeApiService;", "", "()V", "_chatMessages", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/streamchat/domain/model/ChatMessage;", "_messages", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/streamchat/data/remote/ChatMessageDto;", "chatMessages", "Lkotlinx/coroutines/flow/SharedFlow;", "getChatMessages", "()Lkotlinx/coroutines/flow/SharedFlow;", "chatPollingJob", "Lkotlinx/coroutines/Job;", "messages", "Lkotlinx/coroutines/flow/StateFlow;", "getMessages", "()Lkotlinx/coroutines/flow/StateFlow;", "retryCount", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "youtube", "Lcom/google/api/services/youtube/YouTube;", "connectToLiveChat", "", "videoId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disconnectFromLiveChat", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractVideoId", "url", "getLiveChatId", "getLiveChatMessages", "Lcom/streamchat/data/remote/LiveChatMessagesResponse;", "liveChatId", "pageToken", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initializeYouTubeClient", "isValidYouTubeUrl", "", "startChatPolling", "Companion", "app_debug"})
public final class YouTubeApiService {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "StreamChat";
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope scope = null;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job chatPollingJob;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.streamchat.data.remote.ChatMessageDto>> _messages = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.streamchat.data.remote.ChatMessageDto>> messages = null;
    @org.jetbrains.annotations.Nullable()
    private com.google.api.services.youtube.YouTube youtube;
    private int retryCount = 0;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.streamchat.domain.model.ChatMessage> _chatMessages = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.SharedFlow<com.streamchat.domain.model.ChatMessage> chatMessages = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.streamchat.data.remote.YouTubeApiService.Companion Companion = null;
    
    @javax.inject.Inject()
    public YouTubeApiService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.streamchat.data.remote.ChatMessageDto>> getMessages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.SharedFlow<com.streamchat.domain.model.ChatMessage> getChatMessages() {
        return null;
    }
    
    private final void initializeYouTubeClient() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String extractVideoId(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return null;
    }
    
    public final boolean isValidYouTubeUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object connectToLiveChat(@org.jetbrains.annotations.NotNull()
    java.lang.String videoId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object getLiveChatId(java.lang.String videoId, kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    private final void startChatPolling(java.lang.String liveChatId) {
    }
    
    private final java.lang.Object getLiveChatMessages(java.lang.String liveChatId, java.lang.String pageToken, kotlin.coroutines.Continuation<? super com.streamchat.data.remote.LiveChatMessagesResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object disconnectFromLiveChat(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/streamchat/data/remote/YouTubeApiService$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}