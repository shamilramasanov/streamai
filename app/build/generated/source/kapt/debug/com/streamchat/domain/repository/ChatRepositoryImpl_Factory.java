package com.streamchat.domain.repository;

import com.streamchat.data.remote.YouTubeApiService;
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
public final class ChatRepositoryImpl_Factory implements Factory<ChatRepositoryImpl> {
  private final Provider<YouTubeApiService> youTubeApiServiceProvider;

  public ChatRepositoryImpl_Factory(Provider<YouTubeApiService> youTubeApiServiceProvider) {
    this.youTubeApiServiceProvider = youTubeApiServiceProvider;
  }

  @Override
  public ChatRepositoryImpl get() {
    return newInstance(youTubeApiServiceProvider.get());
  }

  public static ChatRepositoryImpl_Factory create(
      Provider<YouTubeApiService> youTubeApiServiceProvider) {
    return new ChatRepositoryImpl_Factory(youTubeApiServiceProvider);
  }

  public static ChatRepositoryImpl newInstance(YouTubeApiService youTubeApiService) {
    return new ChatRepositoryImpl(youTubeApiService);
  }
}
