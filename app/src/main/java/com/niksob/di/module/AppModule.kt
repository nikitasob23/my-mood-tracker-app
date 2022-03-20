package com.niksob.di.module

import com.niksob.domain.navigation.ScreenNavigation
import com.niksob.presentation.MainActivity
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(
    val mainActivity: MainActivity
) {
    @Singleton
    @Provides
    fun provideContext() = mainActivity.applicationContext

    @Provides
    fun provideFragmentManager() = mainActivity.supportFragmentManager
}