package com.niksob.app.navigation.base

import com.niksob.domain.model.NavigationableScreenClass
import com.niksob.domain.navigation.ScreenNavigationWithNavScreenClass
import com.niksob.domain.usecase.navigation.PopBackFragmentUseCase
import com.niksob.domain.usecase.navigation.SetFragmentUseCase

open class FragmentNavigationWithNavScreenClass(
    private val setFragmentUseCase: SetFragmentUseCase,
    popBackFragmentUseCase: PopBackFragmentUseCase,
) : ScreenNavigationWithNavScreenClass,
    FragmentNavigation(
        setFragmentUseCase,
        popBackFragmentUseCase,
    ) {
    override fun moveToNextScreen(screenClass: NavigationableScreenClass) {
        val screen = screenClass.newInstance
        setFragmentUseCase.execute(screen)
    }
}