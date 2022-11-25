package com.niksob.app.navigation.base

import com.niksob.domain.navigation.AppScreenNavigation
import com.niksob.domain.navigation.NavigationableScreen
import com.niksob.domain.usecase.navigation.PopBackFragmentUseCase
import com.niksob.domain.usecase.navigation.SetFragmentUseCase

open class AppFragmentNavigation(
    private val setFragmentUseCase: SetFragmentUseCase,
    private val popBackFragmentUseCase: PopBackFragmentUseCase,
) : AppScreenNavigation {

    override fun moveToNextScreen(screen: NavigationableScreen) = setFragmentUseCase.execute(screen)

    override fun moveToPreviousScreen() = popBackFragmentUseCase.execute()
}