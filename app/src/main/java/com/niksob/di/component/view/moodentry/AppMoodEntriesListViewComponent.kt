package com.niksob.di.component.view.moodentry

import com.niksob.app.view.mood.entry.list.InjectedMoodEntriesListView
import com.niksob.di.module.navigation.AppScreenNavigationModule2
import com.niksob.di.module.view.moodentry.AppMoodEntriesListViewWithMVVMObserverModule
import dagger.Component

@Component(modules = [
    AppMoodEntriesListViewWithMVVMObserverModule::class,
    AppScreenNavigationModule2::class,
])
interface AppMoodEntriesListViewComponent {
    fun inject(moodEntriesListView: InjectedMoodEntriesListView)
}