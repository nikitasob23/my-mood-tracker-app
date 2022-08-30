package com.niksob.di.module.app

import android.content.Context
import android.view.ViewGroup
import com.niksob.app.application.App
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import com.niksob.app.navigation.appprogressbar.MainProgressBar
import dagger.Module
import dagger.Provides

@Module(includes = [ContextModule::class])
class AppProgressBarFromContextModule(
) {
    @Provides
    fun provideProgressBar(layoutComponent: ViewGroup): AppProgressBar = MainProgressBar(layoutComponent)

    @Provides
    fun provideProgressBarLayoutComponent(context: Context) = (context as App).progressBarLayoutComponent
}