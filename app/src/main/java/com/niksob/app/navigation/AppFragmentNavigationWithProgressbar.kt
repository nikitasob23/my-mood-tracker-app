package com.niksob.app.navigation

import com.niksob.domain.navigation.NavigationableScreen
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import com.niksob.domain.usecase.navigation.PopBackFragmentUseCase
import com.niksob.domain.usecase.navigation.SetFragmentUseCase
import com.niksob.domain.utils.logger.AppDebugLogger

class AppFragmentNavigationWithProgressbar(
    setFragmentUseCase: SetFragmentUseCase,
    popBackFragmentUseCase: PopBackFragmentUseCase,
    logger: AppDebugLogger,
    private val progressbar: AppProgressBar,
) : LoggableAppFragmentNavigation(
    setFragmentUseCase,
    popBackFragmentUseCase,
    logger,
) {
    override fun <T : NavigationableScreen> goToNextView(screenClass: Class<T>) {
        progressbar.showProgress()
        super.goToNextView(screenClass)
        progressbar.hideProgress()
    }

    override fun goToPreviousView() {
        progressbar.showProgress()
        super.goToPreviousView()
        progressbar.hideProgress()
    }
}