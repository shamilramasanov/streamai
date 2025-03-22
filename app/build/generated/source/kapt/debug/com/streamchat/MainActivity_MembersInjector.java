package com.streamchat;

import com.streamchat.data.remote.YouTubeApiService;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<YouTubeApiService> youTubeApiServiceProvider;

  public MainActivity_MembersInjector(Provider<YouTubeApiService> youTubeApiServiceProvider) {
    this.youTubeApiServiceProvider = youTubeApiServiceProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<YouTubeApiService> youTubeApiServiceProvider) {
    return new MainActivity_MembersInjector(youTubeApiServiceProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectYouTubeApiService(instance, youTubeApiServiceProvider.get());
  }

  @InjectedFieldSignature("com.streamchat.MainActivity.youTubeApiService")
  public static void injectYouTubeApiService(MainActivity instance,
      YouTubeApiService youTubeApiService) {
    instance.youTubeApiService = youTubeApiService;
  }
}
