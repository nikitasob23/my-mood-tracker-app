package com.niksob.app.view.base.navigation

import com.niksob.app.view.base.injection.BaseInjectableView
import com.niksob.domain.model.NavigationableScreenClass
import com.niksob.domain.navigation.navigatable_screen_class.ScreenNavigation
import javax.inject.Inject

abstract class NavigationableView : BaseInjectableView() {

    @Inject
    lateinit var navigation: ScreenNavigation

    protected open fun moveToNextScreen(screenClass: NavigationableScreenClass) =
        navigation.moveToNextScreen(screenClass)

    protected open fun moveToPreviousScreen() = navigation.moveToPreviousScreen()
}