package com.niksob.di.module.app

import android.view.ViewGroup
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import com.niksob.app.navigation.appprogressbar.MainProgressBar
import dagger.Module
import dagger.Provides

@Module
class AppProgressBarModule(
    private val progressBarLayoutComponent: ViewGroup,
) {
    @Provides
    fun provideProgressBar(): AppProgressBar = MainProgressBar(progressBarLayoutComponent)
}