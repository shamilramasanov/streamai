package com.streamchat.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\b"}, d2 = {"Lcom/streamchat/di/TranslationModule;", "", "()V", "bindTranslationService", "Lcom/streamchat/translation/TranslationService;", "impl", "Lcom/streamchat/translation/DeepLTranslationService;", "Companion", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class TranslationModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.streamchat.di.TranslationModule.Companion Companion = null;
    
    public TranslationModule() {
        super();
    }
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.streamchat.translation.TranslationService bindTranslationService(@org.jetbrains.annotations.NotNull()
    com.streamchat.translation.DeepLTranslationService impl);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/streamchat/di/TranslationModule$Companion;", "", "()V", "provideTranslationCache", "Lcom/streamchat/translation/TranslationCache;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @dagger.Provides()
        @javax.inject.Singleton()
        @org.jetbrains.annotations.NotNull()
        public final com.streamchat.translation.TranslationCache provideTranslationCache() {
            return null;
        }
    }
}