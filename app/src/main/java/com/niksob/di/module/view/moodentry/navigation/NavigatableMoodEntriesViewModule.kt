package com.niksob.di.module.view.moodentry.navigation

import com.niksob.app.view.mood.entry.mvvm.startdataloader.InjectedMoodEntriesListViewWithStartDataLoader
import com.niksob.di.module.navigation.AppScreenNavigationWithNavScreenClassModule
import dagger.Module
import dagger.Provides

@Module(includes = [AppScreenNavigationWithNavScreenClassModule::class])
class NavigatableMoodEntriesViewModule {
    @Provides
    fun provideViewModelClass() = InjectedMoodEntriesListViewWithStartDataLoader::class.java
}