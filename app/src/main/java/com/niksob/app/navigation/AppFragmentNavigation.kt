package com.niksob.app.navigation

import com.niksob.domain.navigation.NavigationableScreen
import com.niksob.domain.navigation.ScreenNavigation
import com.niksob.domain.usecase.navigation.PopBackFragmentUseCase
import com.niksob.domain.usecase.navigation.SetFragmentUseCase

open class AppFragmentNavigation(
    private val setFragmentUseCase: SetFragmentUseCase,
    private val popBackFragmentUseCase: PopBackFragmentUseCase,
) : ScreenNavigation {

    override fun <T : NavigationableScreen> goToNextView(screenClass: Class<T>) {
        val screen = screenClass.newInstance()
        setFragmentUseCase.execute(screen)
    }

    override fun goToPreviousView() = popBackFragmentUseCase.execute()
}