package com.niksob.domain.navigation

interface AppScreenNavigation {

    fun moveToNextScreen(screen: NavigationableScreen)

    fun moveToPreviousScreen()
}