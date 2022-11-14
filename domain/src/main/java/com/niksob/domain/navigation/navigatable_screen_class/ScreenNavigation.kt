package com.niksob.domain.navigation.navigatable_screen_class

import com.niksob.domain.model.NavigationableScreenClass
import com.niksob.domain.navigation.BaseScreenNavigation

interface ScreenNavigation : BaseScreenNavigation {
    fun moveToNextScreen(screenClass: NavigationableScreenClass)
}