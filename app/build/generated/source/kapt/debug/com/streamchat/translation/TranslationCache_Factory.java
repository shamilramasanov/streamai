package com.streamchat.translation;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class TranslationCache_Factory implements Factory<TranslationCache> {
  @Override
  public TranslationCache get() {
    return newInstance();
  }

  public static TranslationCache_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static TranslationCache newInstance() {
    return new TranslationCache();
  }

  private static final class InstanceHolder {
    private static final TranslationCache_Factory INSTANCE = new TranslationCache_Factory();
  }
}
