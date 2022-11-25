package com.niksob.app.navigation.base.progressbar.logger

import com.niksob.domain.navigation.AppScreenNavigation
import com.niksob.domain.navigation.NavigationableScreen
import com.niksob.domain.utils.logger.AppDebugLogger

class LoggableAppFragmentNavigation(
    private val screenNavigation: AppScreenNavigation,
    private val logger: AppDebugLogger,
    private val startMovingMessage: String,
    private val endMovingMessage: String,
) : AppScreenNavigation {

    private val tag = LoggableAppFragmentNavigation::class.simpleName!!

    override fun moveToNextScreen(screen: NavigationableScreen) =
        sequenceOf(screen)
            .onEach(this::logStartMovingToNextScreen)
            .onEach(screenNavigation::moveToNextScreen)
            .forEach(this::logEndMovingToNextScreen)

    override fun moveToPreviousScreen() =
        sequenceOf(null)
            .onEach(this::logStartMovingToNextScreen)
            .onEach { screenNavigation.moveToPreviousScreen() }
            .forEach(this::logEndMovingToNextScreen)

    private fun logStartMovingToNextScreen(screen: NavigationableScreen? = null)  {
        logger.log(tag, startMovingMessage + screen?.apply { this::class.simpleName })
    }

    private fun logEndMovingToNextScreen(screen: NavigationableScreen? = null) {
        logger.log(tag, endMovingMessage + screen?.apply { this::class.simpleName })
    }
}