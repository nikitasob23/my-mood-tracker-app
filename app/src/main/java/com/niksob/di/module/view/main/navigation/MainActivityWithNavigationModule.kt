package com.niksob.di.module.view.main.navigation

import com.niksob.app.view.provider.ViewClassProvider
import com.niksob.di.module.navigation.AppScreenNavigationWithNavScreenClassModule
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [AppScreenNavigationWithNavScreenClassModule::class])
class MainActivityWithNavigationModule {
    @Provides
    @Named("login_view_class")
    fun provideLoginViewClass() = ViewClassProvider.LOGIN_VIEW.clazz

    @Provides
    @Named("mood_entries_view_class")
    fun provideMoodEntriesViewClass() = ViewClassProvider.MOOD_ENTRIES_LIST_VIEW.clazz
}