package com.niksob.app.navigation.progressbar

import com.niksob.app.navigation.logger.LoggableFragmentNavigation
import com.niksob.domain.model.NavigationableScreenClass
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import com.niksob.domain.usecase.navigation.PopBackFragmentUseCase
import com.niksob.domain.usecase.navigation.SetFragmentUseCase
import com.niksob.domain.utils.logger.AppDebugLogger

class FragmentNavigationWithProgressbar(
    setFragmentUseCase: SetFragmentUseCase,
    popBackFragmentUseCase: PopBackFragmentUseCase,
    logger: AppDebugLogger,
    private val progressbar: AppProgressBar,
) : LoggableFragmentNavigation(
    setFragmentUseCase,
    popBackFragmentUseCase,
    logger,
) {
    override fun goToNextView(screenClass: NavigationableScreenClass) {
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