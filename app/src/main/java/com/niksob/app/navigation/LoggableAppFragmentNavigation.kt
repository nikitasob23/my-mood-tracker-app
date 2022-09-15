package com.niksob.app.navigation

import com.niksob.domain.navigation.NavigationableScreen
import com.niksob.domain.usecase.navigation.PopBackFragmentUseCase
import com.niksob.domain.usecase.navigation.SetFragmentUseCase
import com.niksob.domain.utils.logger.AppDebugLogger

private const val NAVIGATE_TO_NEXT_VIEW_PREFIX_MESSAGE = "Go to view: "
private const val NAVIGATE_TO_PREVIOUS_VIEW_MESSAGE = "Go to previous view"

open class LoggableAppFragmentNavigation(
    setFragmentUseCase: SetFragmentUseCase,
    popBackFragmentUseCase: PopBackFragmentUseCase,
    private val logger: AppDebugLogger
) : AppFragmentNavigationWithNavScreenClass(
    setFragmentUseCase,
    popBackFragmentUseCase,
) {
    private val tag get() = LoggableAppFragmentNavigation::class.simpleName!!

    override fun <T : NavigationableScreen> goToNextView(screenClass: Class<T>) {
        super.goToNextView(screenClass)
        logger.log(tag, NAVIGATE_TO_NEXT_VIEW_PREFIX_MESSAGE + screenClass.simpleName)
    }

    override fun goToPreviousView() {
        super.goToPreviousView()
        logger.log(tag, NAVIGATE_TO_PREVIOUS_VIEW_MESSAGE)
    }
}