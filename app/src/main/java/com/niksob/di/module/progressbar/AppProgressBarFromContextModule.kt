package com.niksob.di.module.progressbar

import android.content.Context
import android.view.ViewGroup
import com.niksob.app.application.App
import com.niksob.app.progressbar.base.MainProgressBar
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import com.niksob.di.module.app.ContextModule
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