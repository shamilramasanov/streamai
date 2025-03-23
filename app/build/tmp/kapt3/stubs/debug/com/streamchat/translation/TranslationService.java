package com.streamchat.translation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H&J\u001e\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\tJ*\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\u0007\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/streamchat/translation/TranslationService;", "", "detectLanguage", "", "text", "isTranslationNeeded", "", "targetLang", "translate", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "translateBatch", "", "texts", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface TranslationService {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object translate(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    java.lang.String targetLang, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object translateBatch(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> texts, @org.jetbrains.annotations.NotNull()
    java.lang.String targetLang, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> $completion);
    
    public abstract boolean isTranslationNeeded(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    java.lang.String targetLang);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String detectLanguage(@org.jetbrains.annotations.NotNull()
    java.lang.String text);
}