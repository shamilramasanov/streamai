package com.streamchat.di;

import com.streamchat.translation.TranslationCache;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class TranslationModule_Companion_ProvideTranslationCacheFactory implements Factory<TranslationCache> {
  @Override
  public TranslationCache get() {
    return provideTranslationCache();
  }

  public static TranslationModule_Companion_ProvideTranslationCacheFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static TranslationCache provideTranslationCache() {
    return Preconditions.checkNotNullFromProvides(TranslationModule.Companion.provideTranslationCache());
  }

  private static final class InstanceHolder {
    private static final TranslationModule_Companion_ProvideTranslationCacheFactory INSTANCE = new TranslationModule_Companion_ProvideTranslationCacheFactory();
  }
}
