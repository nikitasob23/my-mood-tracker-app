package com.niksob.di.module.view.auth.loginin.navigation

import com.niksob.app.view.mood.entry.list.progressbar.InjectedMoodEntriesListViewWithProgressbar
import com.niksob.di.module.navigation.AppScreenNavigationWithNavScreenClassModule
import com.niksob.domain.model.NavigationableScreenClass
import dagger.Module
import dagger.Provides

@Module(includes = [AppScreenNavigationWithNavScreenClassModule::class])
class NavigatableLoginInViewModule {
    @Provides
    fun provideMoodEntriesViewClass() =
        NavigationableScreenClass(InjectedMoodEntriesListViewWithProgressbar::class.java)
}