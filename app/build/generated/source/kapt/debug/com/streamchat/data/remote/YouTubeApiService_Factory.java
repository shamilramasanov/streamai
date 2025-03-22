package com.streamchat.data.remote;

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
public final class YouTubeApiService_Factory implements Factory<YouTubeApiService> {
  @Override
  public YouTubeApiService get() {
    return newInstance();
  }

  public static YouTubeApiService_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static YouTubeApiService newInstance() {
    return new YouTubeApiService();
  }

  private static final class InstanceHolder {
    private static final YouTubeApiService_Factory INSTANCE = new YouTubeApiService_Factory();
  }
}
