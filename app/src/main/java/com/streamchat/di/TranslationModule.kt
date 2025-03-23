package com.streamchat.di

import com.streamchat.translation.DeepLTranslationService
import com.streamchat.translation.TranslationService
import com.streamchat.translation.TranslationCache
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class TranslationModule {
    
    @Binds
    @Singleton
    abstract fun bindTranslationService(
        impl: DeepLTranslationService
    ): TranslationService

    companion object {
        @Provides
        @Singleton
        fun provideTranslationCache(): TranslationCache {
            return TranslationCache()
        }
    }
} 