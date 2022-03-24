package com.niksob.di.module.activity

import android.content.Context
import com.niksob.presentation.MainActivity
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActivityModule(
    private val mainActivity: MainActivity
) {
    @Singleton
    @Provides
    fun provideContext(): Context = mainActivity.applicationContext

    @Provides
    fun provideFragmentManager() = mainActivity.supportFragmentManager
}