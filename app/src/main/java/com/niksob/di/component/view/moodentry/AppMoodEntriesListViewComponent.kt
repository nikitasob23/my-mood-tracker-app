package com.niksob.di.component.view.moodentry

import com.niksob.app.view.mood.entry.list.InjectedMoodEntriesListView
import com.niksob.di.module.navigation.AppScreenNavigationWithNavScreenClassModule
import com.niksob.di.module.view.moodentry.AppMoodEntriesListViewWithMVVMObserverModule
import dagger.Component

@Component(modules = [
    AppMoodEntriesListViewWithMVVMObserverModule::class,
    AppScreenNavigationWithNavScreenClassModule::class,
])
interface AppMoodEntriesListViewComponent {
    fun inject(moodEntriesListView: InjectedMoodEntriesListView)
}