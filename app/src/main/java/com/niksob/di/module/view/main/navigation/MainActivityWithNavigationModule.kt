package com.niksob.di.module.view.main.navigation

import com.niksob.app.view.provider.ViewClassProvider
import com.niksob.di.module.navigation.ScreenNavigationModule
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [ScreenNavigationModule::class])
class MainActivityWithNavigationModule {
    @Provides
    @Named("login_view_class")
    fun provideLoginViewClass() = ViewClassProvider.LOGIN_VIEW.clazz

    @Provides
    @Named("mood_entries_view_class")
    fun provideMoodEntriesViewClass() = ViewClassProvider.MOOD_ENTRY_DAY_VIEW.clazz
}