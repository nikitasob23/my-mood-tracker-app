package com.niksob.app.view.base.navigation

import com.niksob.domain.navigation.navigatable_screen_class.ScreenNavigation

open class PreviousViewNavigation(
    private val navigation: ScreenNavigation,
) {

    open fun moveToPreviousScreen() = navigation.moveToPreviousScreen()
}