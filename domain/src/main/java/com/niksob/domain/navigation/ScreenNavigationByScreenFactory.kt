package com.niksob.domain.navigation

interface ScreenNavigationByScreenFactory : ScreenNavigationWithNavScreenClass {

    fun moveToNextScreen(screenFactory: ScreenFactory)
}