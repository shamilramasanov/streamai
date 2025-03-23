package com.streamchat.translation;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class DeepLTranslationService_Factory implements Factory<DeepLTranslationService> {
  private final Provider<Context> contextProvider;

  private final Provider<OkHttpClient> clientProvider;

  private final Provider<TranslationCache> cacheProvider;

  public DeepLTranslationService_Factory(Provider<Context> contextProvider,
      Provider<OkHttpClient> clientProvider, Provider<TranslationCache> cacheProvider) {
    this.contextProvider = contextProvider;
    this.clientProvider = clientProvider;
    this.cacheProvider = cacheProvider;
  }

  @Override
  public DeepLTranslationService get() {
    return newInstance(contextProvider.get(), clientProvider.get(), cacheProvider.get());
  }

  public static DeepLTranslationService_Factory create(Provider<Context> contextProvider,
      Provider<OkHttpClient> clientProvider, Provider<TranslationCache> cacheProvider) {
    return new DeepLTranslationService_Factory(contextProvider, clientProvider, cacheProvider);
  }

  public static DeepLTranslationService newInstance(Context context, OkHttpClient client,
      TranslationCache cache) {
    return new DeepLTranslationService(context, client, cache);
  }
}
