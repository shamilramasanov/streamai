package com.streamchat.ui.screens.home;

import com.streamchat.platforms.core.StreamPlatformFactory;
import com.streamchat.preferences.PreferencesManager;
import com.streamchat.translation.TranslationService;
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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<StreamPlatformFactory> platformFactoryProvider;

  private final Provider<TranslationService> translationServiceProvider;

  private final Provider<PreferencesManager> preferencesManagerProvider;

  public HomeViewModel_Factory(Provider<StreamPlatformFactory> platformFactoryProvider,
      Provider<TranslationService> translationServiceProvider,
      Provider<PreferencesManager> preferencesManagerProvider) {
    this.platformFactoryProvider = platformFactoryProvider;
    this.translationServiceProvider = translationServiceProvider;
    this.preferencesManagerProvider = preferencesManagerProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(platformFactoryProvider.get(), translationServiceProvider.get(), preferencesManagerProvider.get());
  }

  public static HomeViewModel_Factory create(
      Provider<StreamPlatformFactory> platformFactoryProvider,
      Provider<TranslationService> translationServiceProvider,
      Provider<PreferencesManager> preferencesManagerProvider) {
    return new HomeViewModel_Factory(platformFactoryProvider, translationServiceProvider, preferencesManagerProvider);
  }

  public static HomeViewModel newInstance(StreamPlatformFactory platformFactory,
      TranslationService translationService, PreferencesManager preferencesManager) {
    return new HomeViewModel(platformFactory, translationService, preferencesManager);
  }
}
