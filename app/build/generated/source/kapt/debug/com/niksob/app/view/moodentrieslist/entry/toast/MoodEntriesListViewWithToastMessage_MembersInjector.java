package com.niksob.app.view.moodentrieslist.entry.toast;

import com.niksob.app.toast.ToastMessage;
import com.niksob.app.view.moodentrieslist.entry.mvvm.entryloader.MVVMMoodEntriesListView_MembersInjector;
import com.niksob.app.view.moodentrieslist.entry.navigation.NavigatableMoodEntriesListView_MembersInjector;
import com.niksob.app.view.moodentrieslist.entry.progressbar.MoodEntriesListViewWithProgressbar_MembersInjector;
import com.niksob.app.view.moodentrieslist.toast.MoodEntriesListViewWithToastMessage;
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
public final class MoodEntriesListViewWithToastMessage_MembersInjector implements MembersInjector<MoodEntriesListViewWithToastMessage> {
  private final Provider<ScreenNavigationWithNavScreenClass> appNavigationProvider;

  private final Provider<MoodEntriesListViewModel> moodEntriesViewModelProvider;

  private final Provider<AppProgressBar> progressbarProvider;

  private final Provider<ToastMessage> toastMessageProvider;

  public MoodEntriesListViewWithToastMessage_MembersInjector(
      Provider<ScreenNavigationWithNavScreenClass> appNavigationProvider,
      Provider<MoodEntriesListViewModel> moodEntriesViewModelProvider,
      Provider<AppProgressBar> progressbarProvider, Provider<ToastMessage> toastMessageProvider) {
    this.appNavigationProvider = appNavigationProvider;
    this.moodEntriesViewModelProvider = moodEntriesViewModelProvider;
    this.progressbarProvider = progressbarProvider;
    this.toastMessageProvider = toastMessageProvider;
  }

  public static MembersInjector<MoodEntriesListViewWithToastMessage> create(
      Provider<ScreenNavigationWithNavScreenClass> appNavigationProvider,
      Provider<MoodEntriesListViewModel> moodEntriesViewModelProvider,
      Provider<AppProgressBar> progressbarProvider, Provider<ToastMessage> toastMessageProvider) {
    return new MoodEntriesListViewWithToastMessage_MembersInjector(appNavigationProvider, moodEntriesViewModelProvider, progressbarProvider, toastMessageProvider);
  }

  @Override
  public void injectMembers(MoodEntriesListViewWithToastMessage instance) {
    NavigatableMoodEntriesListView_MembersInjector.injectAppNavigation(instance, appNavigationProvider.get());
    MVVMMoodEntriesListView_MembersInjector.injectMoodEntriesViewModel(instance, moodEntriesViewModelProvider.get());
    MoodEntriesListViewWithProgressbar_MembersInjector.injectProgressbar(instance, progressbarProvider.get());
    injectToastMessage(instance, toastMessageProvider.get());
  }

  @InjectedFieldSignature("com.niksob.app.view.mood.entry.toast.MoodEntriesListViewWithToastMessage.toastMessage")
  public static void injectToastMessage(MoodEntriesListViewWithToastMessage instance,
      ToastMessage toastMessage) {
    instance.toastMessage = toastMessage;
  }
}
