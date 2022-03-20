package com.niksob.domain.navigation


interface ScreenNavigation {
    fun goToNextView(screen: NavigationableScreen)

    fun goToPreviousView()
}