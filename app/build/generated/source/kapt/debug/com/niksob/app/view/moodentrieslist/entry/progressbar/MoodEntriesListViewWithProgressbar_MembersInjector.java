package com.niksob.app.view.moodentrieslist.entry.progressbar;

import com.niksob.app.view.moodentrieslist.entry.mvvm.entryloader.MVVMMoodEntriesListView_MembersInjector;
import com.niksob.app.view.moodentrieslist.entry.navigation.NavigatableMoodEntriesListView_MembersInjector;
import com.niksob.app.view.moodentrieslist.progressbar.MoodEntriesListViewWithProgressbar;
import com.niksob.app.viewmodel.moodentry.base.MoodEntriesListViewModel;
import com.niksob.domain.navigation.ScreenNavigationWithNavScreenClass;
import com.niksob.domain.navigation.appprogressbar.AppProgressBar;
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
public final class MoodEntriesListViewWithProgressbar_MembersInjector implements MembersInjector<MoodEntriesListViewWithProgressbar> {
  private final Provider<ScreenNavigationWithNavScreenClass> appNavigationProvider;

  private final Provider<MoodEntriesListViewModel> moodEntriesViewModelProvider;

  private final Provider<AppProgressBar> progressbarProvider;

  public MoodEntriesListViewWithProgressbar_MembersInjector(
      Provider<ScreenNavigationWithNavScreenClass> appNavigationProvider,
      Provider<MoodEntriesListViewModel> moodEntriesViewModelProvider,
      Provider<AppProgressBar> progressbarProvider) {
    this.appNavigationProvider = appNavigationProvider;
    this.moodEntriesViewModelProvider = moodEntriesViewModelProvider;
    this.progressbarProvider = progressbarProvider;
  }

  public static MembersInjector<MoodEntriesListViewWithProgressbar> create(
      Provider<ScreenNavigationWithNavScreenClass> appNavigationProvider,
      Provider<MoodEntriesListViewModel> moodEntriesViewModelProvider,
      Provider<AppProgressBar> progressbarProvider) {
    return new MoodEntriesListViewWithProgressbar_MembersInjector(appNavigationProvider, moodEntriesViewModelProvider, progressbarProvider);
  }

  @Override
  public void injectMembers(MoodEntriesListViewWithProgressbar instance) {
    NavigatableMoodEntriesListView_MembersInjector.injectAppNavigation(instance, appNavigationProvider.get());
    MVVMMoodEntriesListView_MembersInjector.injectMoodEntriesViewModel(instance, moodEntriesViewModelProvider.get());
    injectProgressbar(instance, progressbarProvider.get());
  }

  @InjectedFieldSignature("com.niksob.app.view.mood.entry.progressbar.MoodEntriesListViewWithProgressbar.progressbar")
  public static void injectProgressbar(MoodEntriesListViewWithProgressbar instance,
      AppProgressBar progressbar) {
    instance.progressbar = progressbar;
  }
}
