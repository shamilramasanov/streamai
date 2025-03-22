package com.streamchat.presentation.viewmodels;

import com.streamchat.data.remote.YouTubeApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class ChatViewModel_Factory implements Factory<ChatViewModel> {
  private final Provider<YouTubeApiService> youTubeApiServiceProvider;

  public ChatViewModel_Factory(Provider<YouTubeApiService> youTubeApiServiceProvider) {
    this.youTubeApiServiceProvider = youTubeApiServiceProvider;
  }

  @Override
  public ChatViewModel get() {
    return newInstance(youTubeApiServiceProvider.get());
  }

  public static ChatViewModel_Factory create(
      Provider<YouTubeApiService> youTubeApiServiceProvider) {
    return new ChatViewModel_Factory(youTubeApiServiceProvider);
  }

  public static ChatViewModel newInstance(YouTubeApiService youTubeApiService) {
    return new ChatViewModel(youTubeApiService);
  }
}
