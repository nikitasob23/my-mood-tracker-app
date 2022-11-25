package com.niksob.di.module.navigation

import android.content.Context
import com.niksob.app.R
import com.niksob.app.navigation.base.AppFragmentNavigation
import com.niksob.app.navigation.base.progressbar.AppFragmentNavigationWithProgressbar
import com.niksob.app.navigation.base.progressbar.logger.LoggableAppFragmentNavigation
import com.niksob.di.module.app.ContextModule
import com.niksob.di.module.logger.AppDebugLoggerModule
import com.niksob.di.module.progressbar.AppProgressBarFromContextModule
import com.niksob.di.module.usecase.navigation.PopBackFragmentUseCaseModule
import com.niksob.di.module.usecase.navigation.SetFragmentUseCaseModule
import com.niksob.domain.navigation.AppScreenNavigation
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import com.niksob.domain.usecase.navigation.PopBackFragmentUseCase
import com.niksob.domain.usecase.navigation.SetFragmentUseCase
import com.niksob.domain.utils.logger.AppDebugLogger
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(
    includes = [
        ContextModule::class,
        SetFragmentUseCaseModule::class,
        PopBackFragmentUseCaseModule::class,
        AppProgressBarFromContextModule::class,
        AppDebugLoggerModule::class,
    ]
)
class AppScreenNavigationModule {

    @Provides
    fun provideLoggableAppFragmentNavigation(
        screenNavigation: AppFragmentNavigationWithProgressbar,
        logger: AppDebugLogger,
        @Named("start_moving_message") startMovingMessage: String,
        @Named("end_moving_message") endMovingMessage: String,
    ): AppScreenNavigation =
        LoggableAppFragmentNavigation(
            screenNavigation = screenNavigation,
            logger = logger,
            startMovingMessage = startMovingMessage,
            endMovingMessage = endMovingMessage,
        )

    @Provides
    fun provideAppFragmentNavigationWithProgressbar(
        screenNavigation: AppFragmentNavigation,
        progressbar: AppProgressBar,
    ) =
        AppFragmentNavigationWithProgressbar(
            screenNavigation = screenNavigation,
            progressbar = progressbar,
        )

    @Provides
    fun provideAppScreenNavigation(
        setFragmentUseCase: SetFragmentUseCase,
        popBackFragmentUseCase: PopBackFragmentUseCase,
    ) =
        AppFragmentNavigation(
            setFragmentUseCase = setFragmentUseCase,
            popBackFragmentUseCase = popBackFragmentUseCase,
        )

    @Provides
    @Named("start_moving_message")
    fun provideStartMovingMessage(context: Context) = context.getString(R.string.start_moving_navigation_message)

    @Provides
    @Named("end_moving_message")
    fun provideEndMovingMessage(context: Context) = context.getString(R.string.end_moving_navigation_message)
}