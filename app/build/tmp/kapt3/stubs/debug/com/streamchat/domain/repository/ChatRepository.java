package com.streamchat.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\t\u001a\u00020\u0004H\u00a6@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fH&J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\fH&\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0011"}, d2 = {"Lcom/streamchat/domain/repository/ChatRepository;", "", "connectToChat", "Lkotlin/Result;", "", "streamUrl", "", "connectToChat-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disconnectFromChat", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChatMessages", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/streamchat/domain/model/ChatMessage;", "getConnectionState", "", "app_debug"})
public abstract interface ChatRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object disconnectFromChat(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.streamchat.domain.model.ChatMessage>> getChatMessages();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Boolean> getConnectionState();
}