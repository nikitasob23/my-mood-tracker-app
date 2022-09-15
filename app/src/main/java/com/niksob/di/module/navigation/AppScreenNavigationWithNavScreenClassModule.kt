package com.niksob.di.module.navigation

import com.niksob.app.navigation.AppFragmentNavigationWithProgressbar
import com.niksob.domain.navigation.AppScreenNavigation
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import com.niksob.domain.usecase.navigation.PopBackFragmentUseCase
import com.niksob.domain.usecase.navigation.SetFragmentUseCase
import com.niksob.domain.utils.logger.AppDebugLogger
import dagger.Module
import dagger.Provides

@Module(includes = [AppScreenNavigationModule::class])
class AppScreenNavigationWithNavScreenClassModule {
    @Provides
    fun provideFragmentNavigation(
        setFragmentUseCase: SetFragmentUseCase,
        popBackFragmentUseCase: PopBackFragmentUseCase,
        logger: AppDebugLogger,
        progressbar: AppProgressBar,
    ): AppScreenNavigation =
        AppFragmentNavigationWithProgressbar(
            setFragmentUseCase = setFragmentUseCase,
            popBackFragmentUseCase = popBackFragmentUseCase,
            logger = logger,
            progressbar = progressbar,
        )
}