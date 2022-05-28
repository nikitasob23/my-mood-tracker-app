package com.niksob.di.module.app

import android.widget.FrameLayout
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import com.niksob.app.navigation.appprogressbar.MainProgressBar
import dagger.Module
import dagger.Provides

@Module
class AppProgressBarModule(
    private val progressBarFrameLayout: FrameLayout,
) {
    @Provides
    fun provideProgressBar(): AppProgressBar = MainProgressBar(progressBarFrameLayout)
}