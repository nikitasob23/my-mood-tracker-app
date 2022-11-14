package com.niksob.app.navigation.base

import com.niksob.domain.model.NavigationableScreenClass
import com.niksob.domain.navigation.navigatable_screen_class.ScreenNavigation
import com.niksob.domain.usecase.navigation.PopBackFragmentUseCase
import com.niksob.domain.usecase.navigation.SetFragmentUseCase

open class FragmentNavigation(
    private val setFragmentUseCase: SetFragmentUseCase,
    popBackFragmentUseCase: PopBackFragmentUseCase,
) : ScreenNavigation,
    BaseFragmentNavigation(
        setFragmentUseCase,
        popBackFragmentUseCase,
    ) {
    override fun moveToNextScreen(screenClass: NavigationableScreenClass) {
        val screen = screenClass.newInstance
        setFragmentUseCase.execute(screen)
    }
}