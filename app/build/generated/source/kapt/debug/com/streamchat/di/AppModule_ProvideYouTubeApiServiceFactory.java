package com.streamchat.di;

import com.streamchat.data.remote.YouTubeApiService;
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
public final class AppModule_ProvideYouTubeApiServiceFactory implements Factory<YouTubeApiService> {
  @Override
  public YouTubeApiService get() {
    return provideYouTubeApiService();
  }

  public static AppModule_ProvideYouTubeApiServiceFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static YouTubeApiService provideYouTubeApiService() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideYouTubeApiService());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideYouTubeApiServiceFactory INSTANCE = new AppModule_ProvideYouTubeApiServiceFactory();
  }
}
