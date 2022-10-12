package com.niksob.app.view.base.navigation

import com.niksob.app.view.base.injection.BaseInjectableView
import com.niksob.domain.model.NavigationableScreenClass
import com.niksob.domain.navigation.ScreenNavigationWithNavScreenClass
import javax.inject.Inject

abstract class NavigationableView : BaseInjectableView() {

    @Inject
    lateinit var navigation: ScreenNavigationWithNavScreenClass

    protected open fun moveToNextScreen(screenClass: NavigationableScreenClass) =
        navigation.moveToNextScreen(screenClass)
}