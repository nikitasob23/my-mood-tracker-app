package com.niksob.app.navigation.base

import com.niksob.domain.navigation.ScreenFactory
import com.niksob.domain.navigation.ScreenNavigationByScreenFactory
import com.niksob.domain.usecase.navigation.PopBackFragmentUseCase
import com.niksob.domain.usecase.navigation.SetFragmentUseCase

open class FragmentNavigationWithScreenFactory(
    private val setFragmentUseCase: SetFragmentUseCase,
    popBackFragmentUseCase: PopBackFragmentUseCase,
) : ScreenNavigationByScreenFactory,
    FragmentNavigation(
        setFragmentUseCase = setFragmentUseCase,
        popBackFragmentUseCase = popBackFragmentUseCase,
    ) {

    override fun moveToNextScreen(screenFactory: ScreenFactory) {
        val screen = screenFactory.create()
        setFragmentUseCase.execute(screen)
    }
}