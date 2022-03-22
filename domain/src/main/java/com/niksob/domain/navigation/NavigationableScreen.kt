package com.niksob.domain.navigation

import com.niksob.domain.navigation.appprogressbar.AppProgressBar

interface NavigationableScreen {
    fun attachNavigation(navigation: ScreenNavigation)

    fun attachAppProgressBar(progressBar: AppProgressBar?)
}