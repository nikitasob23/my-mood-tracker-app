package com.niksob.di.component.view.moodentry

import com.niksob.app.view.moodentrieslist.logger.InjectedLoggableMoodEntriesListViewWithEntriesLoader
import com.niksob.app.view.moodentrieslist.viewmodel.startdataloader.InjectedMoodEntriesListViewWithEntriesLoaderWithStartDataLoader
import com.niksob.app.view.moodentrieslist.progressbar.InjectedMoodEntriesListViewWithEntriesLoaderWithProgressbar
import com.niksob.app.view.moodentrieslist.toast.InjectableMoodEntriesListViewWithEntriesLoaderWithToastMessage
import com.niksob.di.component.base.InjectableComponent
import com.niksob.di.module.navigation.ScreenNavigationModule
import com.niksob.di.module.progressbar.AppProgressBarFromContextModule
import com.niksob.di.module.toast.ShortToastMessageModule
import com.niksob.di.module.viewmodel.moodentry.MoodEntriesListViewWithEntriesLoaderObserverModule
import dagger.Component

@Component(modules = [
    MoodEntriesListViewWithEntriesLoaderObserverModule::class,
    ScreenNavigationModule::class,
    AppProgressBarFromContextModule::class,
    ShortToastMessageModule::class,
])
interface MoodEntriesListViewComponent : InjectableComponent {
    fun inject(moodEntriesListView: InjectedMoodEntriesListViewWithEntriesLoaderWithStartDataLoader)

    fun inject(moodEntriesListView: InjectedMoodEntriesListViewWithEntriesLoaderWithProgressbar)

    fun inject(moodEntriesListView: InjectableMoodEntriesListViewWithEntriesLoaderWithToastMessage)

    fun inject(moodEntriesListView: InjectedLoggableMoodEntriesListViewWithEntriesLoader)
}