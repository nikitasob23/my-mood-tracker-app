package com.niksob.domain.navigation

interface ScreenNavigation {
    fun <T : NavigationableScreen> moveToNextScreen(screenClass: Class<T>)

    fun moveToPreviousScreen()
}