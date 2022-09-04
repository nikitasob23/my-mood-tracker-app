package com.niksob.di.module.navigation

import android.content.Context
import androidx.fragment.app.FragmentManager
import com.niksob.app.application.App
import com.niksob.app.navigation.FragmentSetter
import com.niksob.app.navigation.LoggableAppFragmentNavigation
import com.niksob.di.module.app.*
import com.niksob.di.module.logger.AppDebugLoggerModule
import com.niksob.domain.navigation.ScreenNavigation
import com.niksob.domain.navigation.ScreenSetter
import com.niksob.domain.usecase.navigation.PopBackFragmentUseCase
import com.niksob.domain.usecase.navigation.SetFragmentUseCase
import com.niksob.domain.utils.logger.AppDebugLogger
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        ContextModule::class,
        AppDebugLoggerModule::class,
    ]
)
class AppScreenNavigationModule {

    @Provides
    fun provideFragmentNavigation(
        setFragmentUseCase: SetFragmentUseCase,
        popBackFragmentUseCase: PopBackFragmentUseCase,
        logger: AppDebugLogger,
    ): ScreenNavigation =
        LoggableAppFragmentNavigation(
            setFragmentUseCase = setFragmentUseCase,
            popBackFragmentUseCase = popBackFragmentUseCase,
            logger = logger,
        )

    @Provides
    fun provideSetFragmentUseCase(screenSetter: ScreenSetter) = SetFragmentUseCase(screenSetter)

    @Provides
    fun providePopBackFragmentUseCase(screenSetter: ScreenSetter) = PopBackFragmentUseCase(screenSetter)

    @Provides
    fun provideFragmentSetter(manager: FragmentManager): ScreenSetter = FragmentSetter(manager)

    @Provides
    fun provideFragmentManager(context: Context) = (context as App).fragmentManager
}