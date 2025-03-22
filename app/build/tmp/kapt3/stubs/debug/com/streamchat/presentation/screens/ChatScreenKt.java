package com.streamchat.presentation.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a(\u0010\u0006\u001a\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0007\u001a\u001a\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007\u001a0\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00162\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u00a8\u0006\u0017"}, d2 = {"ChatMessageItem", "", "message", "Lcom/streamchat/domain/model/ChatMessage;", "modifier", "Landroidx/compose/ui/Modifier;", "ChatMessagesList", "messages", "", "listState", "Landroidx/compose/foundation/lazy/LazyListState;", "ChatMoodIndicator", "mood", "", "ChatScreen", "streamUrl", "", "viewModel", "Lcom/streamchat/presentation/viewmodels/ChatViewModel;", "ErrorMessage", "error", "onRetry", "Lkotlin/Function0;", "app_debug"})
public final class ChatScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void ChatScreen(@org.jetbrains.annotations.NotNull()
    java.lang.String streamUrl, @org.jetbrains.annotations.NotNull()
    com.streamchat.presentation.viewmodels.ChatViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ChatMoodIndicator(float mood) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ChatMessagesList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.streamchat.domain.model.ChatMessage> messages, @org.jetbrains.annotations.NotNull()
    androidx.compose.foundation.lazy.LazyListState listState, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ChatMessageItem(@org.jetbrains.annotations.NotNull()
    com.streamchat.domain.model.ChatMessage message, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ErrorMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String error, @org.jetbrains.annotations.NotNull()
    java.lang.String streamUrl, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onRetry, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
}