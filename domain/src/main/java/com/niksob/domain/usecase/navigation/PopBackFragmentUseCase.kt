package com.niksob.domain.usecase.navigation

import com.niksob.domain.navigation.ScreenSetter

class PopBackFragmentUseCase(
    private val screenSetter: ScreenSetter
) {
    fun execute() {
        screenSetter.setPrevious()
    }
}