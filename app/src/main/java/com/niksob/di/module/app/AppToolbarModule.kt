package com.niksob.di.module.app

import androidx.appcompat.widget.Toolbar
import dagger.Module
import dagger.Provides

@Module
class AppToolbarModule(
    private val appToolbar: Toolbar
) {
    @Provides
    fun provideAppToolbar() = appToolbar
}