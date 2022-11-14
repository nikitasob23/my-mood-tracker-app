package com.niksob.domain.navigation

interface BaseScreenNavigation {
    fun <T : NavigationableScreen> moveToNextScreen(screenClass: Class<T>)

    fun moveToPreviousScreen()
}