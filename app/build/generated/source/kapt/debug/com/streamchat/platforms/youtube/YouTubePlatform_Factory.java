package com.streamchat.platforms.youtube;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class YouTubePlatform_Factory implements Factory<YouTubePlatform> {
  @Override
  public YouTubePlatform get() {
    return newInstance();
  }

  public static YouTubePlatform_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static YouTubePlatform newInstance() {
    return new YouTubePlatform();
  }

  private static final class InstanceHolder {
    private static final YouTubePlatform_Factory INSTANCE = new YouTubePlatform_Factory();
  }
}
