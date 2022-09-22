package com.niksob.domain.navigation

import com.niksob.domain.model.NavigationableScreenClass

interface ScreenNavigationWithNavScreenClass : ScreenNavigation {
    fun goToNextView(screenClass: NavigationableScreenClass)
}