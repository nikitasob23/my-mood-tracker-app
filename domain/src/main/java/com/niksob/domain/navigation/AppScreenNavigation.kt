package com.niksob.domain.navigation

import com.niksob.domain.model.NavigationableScreenClass

interface AppScreenNavigation {
    fun goToNextView(screenClass: NavigationableScreenClass)

    fun goToPreviousView()
}