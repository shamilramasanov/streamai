package com.streamchat.preferences;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0086@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\u0013R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0015"}, d2 = {"Lcom/streamchat/preferences/PreferencesManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "autoTranslateEnabled", "Lkotlinx/coroutines/flow/Flow;", "", "getAutoTranslateEnabled", "()Lkotlinx/coroutines/flow/Flow;", "targetLanguage", "", "getTargetLanguage", "setAutoTranslateEnabled", "", "enabled", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setTargetLanguage", "language", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PreferencesKeys", "app_debug"})
public final class PreferencesManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.lang.Boolean> autoTranslateEnabled = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.lang.String> targetLanguage = null;
    
    @javax.inject.Inject()
    public PreferencesManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> getAutoTranslateEnabled() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getTargetLanguage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setAutoTranslateEnabled(boolean enabled, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setTargetLanguage(@org.jetbrains.annotations.NotNull()
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/streamchat/preferences/PreferencesManager$PreferencesKeys;", "", "()V", "AUTO_TRANSLATE", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "getAUTO_TRANSLATE", "()Landroidx/datastore/preferences/core/Preferences$Key;", "TARGET_LANGUAGE", "", "getTARGET_LANGUAGE", "app_debug"})
    static final class PreferencesKeys {
        @org.jetbrains.annotations.NotNull()
        private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> AUTO_TRANSLATE = null;
        @org.jetbrains.annotations.NotNull()
        private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> TARGET_LANGUAGE = null;
        @org.jetbrains.annotations.NotNull()
        public static final com.streamchat.preferences.PreferencesManager.PreferencesKeys INSTANCE = null;
        
        private PreferencesKeys() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> getAUTO_TRANSLATE() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> getTARGET_LANGUAGE() {
            return null;
        }
    }
}