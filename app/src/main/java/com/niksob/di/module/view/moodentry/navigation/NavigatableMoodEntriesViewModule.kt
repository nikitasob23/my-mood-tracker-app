package com.niksob.di.module.view.moodentry.navigation

import com.niksob.app.view.moodentrieslist.viewmodel.startdataloader.InjectedMoodEntriesListViewWithEntriesLoaderWithStartDataLoader
import com.niksob.di.module.navigation.AppScreenNavigationWithNavScreenClassModule
import dagger.Module
import dagger.Provides

@Module(includes = [AppScreenNavigationWithNavScreenClassModule::class])
class NavigatableMoodEntriesViewModule {
    @Provides
    fun provideViewModelClass() = InjectedMoodEntriesListViewWithEntriesLoaderWithStartDataLoader::class.java
}