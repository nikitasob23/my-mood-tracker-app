package com.niksob.di.module.navigation

import androidx.fragment.app.FragmentManager
import com.niksob.app.navigation.base.FragmentNavigationWithScreenFactory
import com.niksob.app.navigation.progressbar.FragmentNavigationByProgressbar
import com.niksob.app.navigation.fragmentsetter.FragmentSetter
import com.niksob.di.module.app.*
import com.niksob.di.module.progressbar.AppProgressBarFromContextModule
import com.niksob.di.module.logger.AppDebugLoggerModule
import com.niksob.domain.navigation.ScreenNavigation
import com.niksob.domain.navigation.ScreenNavigationWithNavScreenClass
import com.niksob.domain.navigation.ScreenNavigationByScreenFactory
import com.niksob.domain.navigation.ScreenSetter
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import com.niksob.domain.usecase.navigation.PopBackFragmentUseCase
import com.niksob.domain.usecase.navigation.SetFragmentUseCase
import com.niksob.domain.utils.logger.AppDebugLogger
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        ContextModule::class,
        AppDebugLoggerModule::class,
        AppProgressBarFromContextModule::class,
        AppFragmentManagerModule::class,
    ]
)
class ScreenNavigationModule {

    @Provides
    fun provideFragmentNavigationWithProgressbar(
        setFragmentUseCase: SetFragmentUseCase,
        popBackFragmentUseCase: PopBackFragmentUseCase,
        logger: AppDebugLogger,
        progressbar: AppProgressBar,
    ): ScreenNavigationWithNavScreenClass =
        FragmentNavigationByProgressbar(
            setFragmentUseCase = setFragmentUseCase,
            popBackFragmentUseCase = popBackFragmentUseCase,
            logger = logger,
            progressbar = progressbar,
        )

    @Provides
    fun provideFragmentNavigation(
        navigation: ScreenNavigationWithNavScreenClass,
    ): ScreenNavigationByScreenFactory =
        navigation as FragmentNavigationWithScreenFactory

    @Provides
    fun provideScreenNavigation(
        navigation: ScreenNavigationWithNavScreenClass,
    ): ScreenNavigation =
        navigation as FragmentNavigationWithScreenFactory

    @Provides
    fun provideSetFragmentUseCase(screenSetter: ScreenSetter) = SetFragmentUseCase(screenSetter)

    @Provides
    fun providePopBackFragmentUseCase(screenSetter: ScreenSetter) = PopBackFragmentUseCase(screenSetter)

    @Provides
    fun provideFragmentSetter(manager: FragmentManager): ScreenSetter = FragmentSetter(manager)
}