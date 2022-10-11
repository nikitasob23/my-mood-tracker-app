package com.niksob.app.view.auth.login.navigation

import com.niksob.app.view.auth.login.base.InjectableBaseLoginView
import com.niksob.domain.model.NavigationableScreenClass
import com.niksob.domain.navigation.ScreenNavigationWithNavScreenClass
import javax.inject.Inject
import javax.inject.Named

open class NavigatableLoginView : InjectableBaseLoginView() {

    @Inject
    lateinit var appNavigation: ScreenNavigationWithNavScreenClass

    @Inject
    @Named("login_in_view_class")
    lateinit var loginInViewClass: NavigationableScreenClass

    @Inject
    @Named("sign_up_view_class")
    lateinit var signUpViewClass: NavigationableScreenClass

    protected open fun goToLoginView() = appNavigation.moveToNextScreen(loginInViewClass)

    protected open fun goToSignUpView() = appNavigation.moveToNextScreen(signUpViewClass)
}