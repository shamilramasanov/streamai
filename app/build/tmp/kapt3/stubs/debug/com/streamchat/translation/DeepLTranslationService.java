package com.streamchat.translation;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u001e\u0010\u0011\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u0012J*\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u00142\u0006\u0010\u0010\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/streamchat/translation/DeepLTranslationService;", "Lcom/streamchat/translation/TranslationService;", "context", "Landroid/content/Context;", "client", "Lokhttp3/OkHttpClient;", "cache", "Lcom/streamchat/translation/TranslationCache;", "(Landroid/content/Context;Lokhttp3/OkHttpClient;Lcom/streamchat/translation/TranslationCache;)V", "apiKey", "", "baseUrl", "detectLanguage", "text", "isTranslationNeeded", "", "targetLang", "translate", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "translateBatch", "", "texts", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class DeepLTranslationService implements com.streamchat.translation.TranslationService {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final okhttp3.OkHttpClient client = null;
    @org.jetbrains.annotations.NotNull()
    private final com.streamchat.translation.TranslationCache cache = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String apiKey = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String baseUrl = "https://api-free.deepl.com/v2";
    
    @javax.inject.Inject()
    public DeepLTranslationService(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient client, @org.jetbrains.annotations.NotNull()
    com.streamchat.translation.TranslationCache cache) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object translate(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    java.lang.String targetLang, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object translateBatch(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> texts, @org.jetbrains.annotations.NotNull()
    java.lang.String targetLang, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    public boolean isTranslationNeeded(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    java.lang.String targetLang) {
        return false;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String detectLanguage(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
        return null;
    }
}