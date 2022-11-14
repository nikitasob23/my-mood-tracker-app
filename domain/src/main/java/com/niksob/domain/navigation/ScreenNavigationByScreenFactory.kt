package com.niksob.domain.navigation

import com.niksob.domain.navigation.navigatable_screen_class.ScreenNavigation

interface ScreenNavigationByScreenFactory : ScreenNavigation {

    fun moveToNextScreen(screenFactory: ScreenFactory)
}