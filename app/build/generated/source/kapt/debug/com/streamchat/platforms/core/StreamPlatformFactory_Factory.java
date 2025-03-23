package com.streamchat.platforms.core;

import com.streamchat.platforms.tiktok.TikTokPlatform;
import com.streamchat.platforms.youtube.YouTubePlatform;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class StreamPlatformFactory_Factory implements Factory<StreamPlatformFactory> {
  private final Provider<YouTubePlatform> youtubePlatformProvider;

  private final Provider<TikTokPlatform> tiktokPlatformProvider;

  public StreamPlatformFactory_Factory(Provider<YouTubePlatform> youtubePlatformProvider,
      Provider<TikTokPlatform> tiktokPlatformProvider) {
    this.youtubePlatformProvider = youtubePlatformProvider;
    this.tiktokPlatformProvider = tiktokPlatformProvider;
  }

  @Override
  public StreamPlatformFactory get() {
    return newInstance(youtubePlatformProvider.get(), tiktokPlatformProvider.get());
  }

  public static StreamPlatformFactory_Factory create(
      Provider<YouTubePlatform> youtubePlatformProvider,
      Provider<TikTokPlatform> tiktokPlatformProvider) {
    return new StreamPlatformFactory_Factory(youtubePlatformProvider, tiktokPlatformProvider);
  }

  public static StreamPlatformFactory newInstance(YouTubePlatform youtubePlatform,
      TikTokPlatform tiktokPlatform) {
    return new StreamPlatformFactory(youtubePlatform, tiktokPlatform);
  }
}
