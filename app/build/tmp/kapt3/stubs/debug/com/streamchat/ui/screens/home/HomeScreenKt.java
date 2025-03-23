package com.streamchat.ui.screens.home;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a2\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a$\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a\u0012\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u001a:\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00152\u0006\u0010\u0018\u001a\u00020\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u001a\u001a\u00020\bH\u0007\u00a8\u0006\u001b"}, d2 = {"ConnectSection", "", "onConnectClick", "Lkotlin/Function1;", "", "onDisconnectClick", "Lkotlin/Function0;", "isConnected", "", "FilterSection", "selectedMessageType", "Lcom/streamchat/platforms/core/MessageType;", "onFilterChange", "HomeScreen", "viewModel", "Lcom/streamchat/ui/screens/home/HomeViewModel;", "MessageItem", "message", "Lcom/streamchat/platforms/core/StreamMessage;", "StatsSection", "stats", "", "Lcom/streamchat/platforms/core/PlatformType;", "", "selectedPlatform", "onTranslationToggle", "isAutomaticTranslationEnabled", "app_debug"})
public final class HomeScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void HomeScreen(@org.jetbrains.annotations.NotNull()
    com.streamchat.ui.screens.home.HomeViewModel viewModel) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void ConnectSection(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onConnectClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDisconnectClick, boolean isConnected) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void MessageItem(@org.jetbrains.annotations.NotNull()
    com.streamchat.platforms.core.StreamMessage message) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void FilterSection(@org.jetbrains.annotations.NotNull()
    com.streamchat.platforms.core.MessageType selectedMessageType, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.streamchat.platforms.core.MessageType, kotlin.Unit> onFilterChange) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void StatsSection(@org.jetbrains.annotations.NotNull()
    java.util.Map<com.streamchat.platforms.core.PlatformType, java.lang.Integer> stats, @org.jetbrains.annotations.NotNull()
    java.lang.String selectedPlatform, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onTranslationToggle, boolean isAutomaticTranslationEnabled) {
    }
}