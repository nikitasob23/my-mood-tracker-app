package com.niksob.app.view.moodentrieslist.entry.navigation;

import com.niksob.app.view.moodentrieslist.navigation.NavigatableMoodEntriesListView;
import com.niksob.domain.navigation.ScreenNavigationWithNavScreenClass;
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
    "rawtypes"
})
public final class NavigatableMoodEntriesListView_MembersInjector implements MembersInjector<NavigatableMoodEntriesListView> {
  private final Provider<ScreenNavigationWithNavScreenClass> appNavigationProvider;

  public NavigatableMoodEntriesListView_MembersInjector(
      Provider<ScreenNavigationWithNavScreenClass> appNavigationProvider) {
    this.appNavigationProvider = appNavigationProvider;
  }

  public static MembersInjector<NavigatableMoodEntriesListView> create(
      Provider<ScreenNavigationWithNavScreenClass> appNavigationProvider) {
    return new NavigatableMoodEntriesListView_MembersInjector(appNavigationProvider);
  }

  @Override
  public void injectMembers(NavigatableMoodEntriesListView instance) {
    injectAppNavigation(instance, appNavigationProvider.get());
  }

  @InjectedFieldSignature("com.niksob.app.view.mood.entry.navigation.NavigatableMoodEntriesListView.appNavigation")
  public static void injectAppNavigation(NavigatableMoodEntriesListView instance,
      ScreenNavigationWithNavScreenClass appNavigation) {
    instance.appNavigation = appNavigation;
  }
}
