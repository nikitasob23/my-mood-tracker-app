package com.niksob.di.component.view.moodentry

import com.niksob.app.view.mood.entry.list.mvvm.startdataloader.InjectedMoodEntriesListViewWithStartDataLoader
import com.niksob.app.view.mood.entry.list.progressbar.InjectedMoodEntriesListViewWithProgressbar
import com.niksob.di.component.InjectableComponent
import com.niksob.di.module.navigation.AppScreenNavigationWithNavScreenClassModule
import com.niksob.di.module.progressbar.AppProgressBarFromContextModule
import com.niksob.di.module.viewmodel.moodentry.MoodEntriesListViewWithMVVMObserverModule
import dagger.Component

@Component(modules = [
    MoodEntriesListViewWithMVVMObserverModule::class,
    AppScreenNavigationWithNavScreenClassModule::class,
    AppProgressBarFromContextModule::class,
])
interface MoodEntriesListViewComponent : InjectableComponent {
    fun inject(moodEntriesListView: InjectedMoodEntriesListViewWithStartDataLoader)

    fun inject(moodEntriesListView: InjectedMoodEntriesListViewWithProgressbar)
}