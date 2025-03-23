package com.streamchat.translation;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\u0007J\u0018\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/streamchat/translation/TranslationCache;", "", "()V", "cache", "", "", "cacheTranslation", "", "text", "targetLang", "translation", "clear", "getCachedTranslation", "app_debug"})
public final class TranslationCache {
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.String> cache = null;
    
    @javax.inject.Inject()
    public TranslationCache() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCachedTranslation(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    java.lang.String targetLang) {
        return null;
    }
    
    public final void cacheTranslation(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    java.lang.String targetLang, @org.jetbrains.annotations.NotNull()
    java.lang.String translation) {
    }
    
    public final void clear() {
    }
}