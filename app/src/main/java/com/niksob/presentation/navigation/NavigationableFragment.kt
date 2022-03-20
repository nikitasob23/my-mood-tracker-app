package com.niksob.presentation.navigation

import androidx.fragment.app.Fragment
import com.niksob.domain.navigation.NavigationableScreen
import com.niksob.domain.navigation.ScreenNavigation

open class NavigationableFragment : NavigationableScreen, Fragment() {
    var navigation: ScreenNavigation? = null
        private set

    override fun attachNavigation(navigation: ScreenNavigation) {
        this.navigation = navigation
    }
}