package com.niksob.domain.navigation

interface ScreenNavigation {
    fun <T : NavigationableScreen> goToNextView(screenClass: Class<T>)

    fun goToPreviousView()
}