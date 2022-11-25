package com.niksob.app.view.base.navigation

import com.niksob.domain.navigation.AppScreenNavigation

open class PreviousViewNavigation(
    private val navigation: AppScreenNavigation,
) {

    open fun moveToPreviousScreen() = navigation.moveToPreviousScreen()
}