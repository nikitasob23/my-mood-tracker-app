package com.niksob.app.navigation.base.progressbar

import com.niksob.domain.navigation.AppScreenNavigation
import com.niksob.domain.navigation.NavigationableScreen
import com.niksob.domain.navigation.appprogressbar.AppProgressBar

open class AppFragmentNavigationWithProgressbar(
    private val screenNavigation: AppScreenNavigation,
    private val progressbar: AppProgressBar,
) : AppScreenNavigation {

    override fun moveToNextScreen(screen: NavigationableScreen) =
        sequenceOf(screen)
            .onEach { progressbar.showProgress() }
            .onEach(screenNavigation::moveToNextScreen)
            .forEach  { _ -> progressbar.hideProgress() }

    override fun moveToPreviousScreen() =
        sequenceOf(null)
            .onEach { progressbar.showProgress() }
            .onEach { screenNavigation.moveToPreviousScreen() }
            .forEach { _ -> progressbar.hideProgress() }
}