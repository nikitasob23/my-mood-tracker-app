package com.niksob.app.navigation.progressbar

import com.niksob.app.navigation.logger.LoggableFragmentNavigation
import com.niksob.domain.model.NavigationableScreenClass
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import com.niksob.domain.usecase.navigation.PopBackFragmentUseCase
import com.niksob.domain.usecase.navigation.SetFragmentUseCase
import com.niksob.domain.utils.logger.AppDebugLogger

open class FragmentNavigationByProgressbar(
    setFragmentUseCase: SetFragmentUseCase,
    popBackFragmentUseCase: PopBackFragmentUseCase,
    logger: AppDebugLogger,
    private val progressbar: AppProgressBar,
) : LoggableFragmentNavigation(
    setFragmentUseCase,
    popBackFragmentUseCase,
    logger,
) {
    override fun moveToNextScreen(screenClass: NavigationableScreenClass) {
        progressbar.showProgress()
        super.moveToNextScreen(screenClass)
        progressbar.hideProgress()
    }

    override fun moveToPreviousScreen() {
        progressbar.showProgress()
        super.moveToPreviousScreen()
        progressbar.hideProgress()
    }
}