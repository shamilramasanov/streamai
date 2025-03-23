package com.streamchat.platforms.tiktok;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

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
public final class TikTokPlatform_Factory implements Factory<TikTokPlatform> {
  private final Provider<OkHttpClient> clientProvider;

  public TikTokPlatform_Factory(Provider<OkHttpClient> clientProvider) {
    this.clientProvider = clientProvider;
  }

  @Override
  public TikTokPlatform get() {
    return newInstance(clientProvider.get());
  }

  public static TikTokPlatform_Factory create(Provider<OkHttpClient> clientProvider) {
    return new TikTokPlatform_Factory(clientProvider);
  }

  public static TikTokPlatform newInstance(OkHttpClient client) {
    return new TikTokPlatform(client);
  }
}
