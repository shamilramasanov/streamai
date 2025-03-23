package com.streamchat.platforms.tiktok;

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
public final class TikTokWebSocketImpl_Factory implements Factory<TikTokWebSocketImpl> {
  @Override
  public TikTokWebSocketImpl get() {
    return newInstance();
  }

  public static TikTokWebSocketImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static TikTokWebSocketImpl newInstance() {
    return new TikTokWebSocketImpl();
  }

  private static final class InstanceHolder {
    private static final TikTokWebSocketImpl_Factory INSTANCE = new TikTokWebSocketImpl_Factory();
  }
}
