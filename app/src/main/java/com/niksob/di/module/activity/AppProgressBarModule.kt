package com.niksob.di.module.activity

import android.widget.FrameLayout
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import com.niksob.presentation.navigation.appprogressbar.MainProgressBar
import dagger.Module
import dagger.Provides

@Module
class AppProgressBarModule(
    private val progressBarFrameLayout: FrameLayout,
) {
    @Provides
    fun provideProgressBar(): AppProgressBar = MainProgressBar(progressBarFrameLayout)
}