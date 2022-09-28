package com.niksob.app.view.moodentrieslist.entry.mvvm.entryloader;

import com.niksob.app.view.moodentrieslist.entry.navigation.NavigatableMoodEntriesListView_MembersInjector;
import com.niksob.app.view.moodentrieslist.mvvm.entryloader.MVVMMoodEntriesListView;
import com.niksob.app.viewmodel.moodentry.base.MoodEntriesListViewModel;
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
public final class MVVMMoodEntriesListView_MembersInjector implements MembersInjector<MVVMMoodEntriesListView> {
  private final Provider<ScreenNavigationWithNavScreenClass> appNavigationProvider;

  private final Provider<MoodEntriesListViewModel> moodEntriesViewModelProvider;

  public MVVMMoodEntriesListView_MembersInjector(
      Provider<ScreenNavigationWithNavScreenClass> appNavigationProvider,
      Provider<MoodEntriesListViewModel> moodEntriesViewModelProvider) {
    this.appNavigationProvider = appNavigationProvider;
    this.moodEntriesViewModelProvider = moodEntriesViewModelProvider;
  }

  public static MembersInjector<MVVMMoodEntriesListView> create(
      Provider<ScreenNavigationWithNavScreenClass> appNavigationProvider,
      Provider<MoodEntriesListViewModel> moodEntriesViewModelProvider) {
    return new MVVMMoodEntriesListView_MembersInjector(appNavigationProvider, moodEntriesViewModelProvider);
  }

  @Override
  public void injectMembers(MVVMMoodEntriesListView instance) {
    NavigatableMoodEntriesListView_MembersInjector.injectAppNavigation(instance, appNavigationProvider.get());
    injectMoodEntriesViewModel(instance, moodEntriesViewModelProvider.get());
  }

  @InjectedFieldSignature("com.niksob.app.view.mood.entry.mvvm.entryloader.MVVMMoodEntriesListView.moodEntriesViewModel")
  public static void injectMoodEntriesViewModel(MVVMMoodEntriesListView instance,
      MoodEntriesListViewModel moodEntriesViewModel) {
    instance.moodEntriesViewModel = moodEntriesViewModel;
  }
}
