package com.niksob.di.module.view.main.navigation

import com.niksob.app.view.auth.login.navigation.InjectedNavigatableLoginView
import com.niksob.app.view.mood.entry.list.mvvm.startdataloader.InjectedMoodEntriesListViewWithStartDataLoader
import com.niksob.di.module.navigation.AppScreenNavigationWithNavScreenClassModule
import com.niksob.domain.navigation.NavigationableScreen
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [AppScreenNavigationWithNavScreenClassModule::class])
class MainActivityWithNavigationModule {
    @Provides
    @Named("login_view_class")
    fun provideLoginViewClass(): Class<out NavigationableScreen> =
        InjectedNavigatableLoginView::class.java

    @Provides
    @Named("mood_entries_view_class")
    fun provideMoodEntriesViewClass(): Class<out NavigationableScreen> =
        InjectedMoodEntriesListViewWithStartDataLoader::class.java
}