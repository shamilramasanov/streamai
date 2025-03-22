package com.streamchat.presentation.viewmodels;

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
public final class StreamInputViewModel_Factory implements Factory<StreamInputViewModel> {
  @Override
  public StreamInputViewModel get() {
    return newInstance();
  }

  public static StreamInputViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static StreamInputViewModel newInstance() {
    return new StreamInputViewModel();
  }

  private static final class InstanceHolder {
    private static final StreamInputViewModel_Factory INSTANCE = new StreamInputViewModel_Factory();
  }
}
