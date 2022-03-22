package com.niksob.di.module

import android.widget.FrameLayout
import android.widget.ProgressBar
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import com.niksob.presentation.navigation.appprogressbar.MainProgressBar
import dagger.Module
import dagger.Provides

@Module
class AppProgressBarModule(
    private val progressBar: ProgressBar,
    private val mainScreen: FrameLayout,
) {
    @Provides
    fun provideProgressBar(): AppProgressBar = MainProgressBar(progressBar, mainScreen)
}