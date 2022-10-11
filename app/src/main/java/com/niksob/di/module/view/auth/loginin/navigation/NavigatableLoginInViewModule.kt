package com.niksob.di.module.view.auth.loginin.navigation

import com.niksob.app.view.provider.ViewClassProvider
import com.niksob.di.module.navigation.ScreenNavigationModule
import com.niksob.domain.model.NavigationableScreenClass
import dagger.Module
import dagger.Provides

@Module(includes = [ScreenNavigationModule::class])
class NavigatableLoginInViewModule {
    @Provides
    fun provideMoodEntriesViewClass() =
        NavigationableScreenClass(ViewClassProvider.MOOD_ENTRIES_LIST_VIEW.clazz)
}