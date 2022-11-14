package com.niksob.app.navigation.base

import com.niksob.domain.navigation.NavigationableScreen
import com.niksob.domain.navigation.BaseScreenNavigation
import com.niksob.domain.usecase.navigation.PopBackFragmentUseCase
import com.niksob.domain.usecase.navigation.SetFragmentUseCase

open class BaseFragmentNavigation(
    private val setFragmentUseCase: SetFragmentUseCase,
    private val popBackFragmentUseCase: PopBackFragmentUseCase,
) : BaseScreenNavigation {

    override fun <T : NavigationableScreen> moveToNextScreen(screenClass: Class<T>) {
        val screen = screenClass.newInstance()
        setFragmentUseCase.execute(screen)
    }

    override fun moveToPreviousScreen() = popBackFragmentUseCase.execute()
}