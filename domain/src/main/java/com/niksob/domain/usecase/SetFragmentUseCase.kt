package com.niksob.domain.usecase

import com.niksob.domain.navigation.NavigationableScreen
import com.niksob.domain.navigation.ScreenSetter

class SetFragmentUseCase(
    private val screenSetter: ScreenSetter,
) {
    fun execute(screen: NavigationableScreen) {
        screenSetter.setNext(screen)
    }
}