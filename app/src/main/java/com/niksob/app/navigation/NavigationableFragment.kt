package com.niksob.app.navigation

import androidx.fragment.app.Fragment
import com.niksob.domain.navigation.NavigationableScreen
import com.niksob.domain.navigation.ScreenNavigation
import com.niksob.domain.navigation.appprogressbar.AppProgressBar

open class NavigationableFragment : NavigationableScreen, Fragment() {
    var navigation: ScreenNavigation? = null
        private set

    var progressBar: AppProgressBar? = null
        private set

    override fun attachNavigation(navigation: ScreenNavigation) {
        this.navigation = navigation
    }

    override fun attachAppProgressBar(progressBar: AppProgressBar?) {
        this.progressBar = progressBar
    }
}