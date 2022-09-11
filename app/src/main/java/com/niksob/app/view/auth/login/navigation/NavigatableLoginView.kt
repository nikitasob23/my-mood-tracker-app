package com.niksob.app.view.auth.login.navigation

import com.niksob.domain.model.NavigationableScreenClass
import com.niksob.app.view.auth.login.InjectableLoginView
import com.niksob.domain.navigation.AppScreenNavigation
import javax.inject.Inject
import javax.inject.Named

open class NavigatableLoginView : InjectableLoginView() {

    @Inject
    lateinit var appNavigation: AppScreenNavigation

    @Inject
    @Named("login_in_view_class")
    lateinit var loginInViewClass: NavigationableScreenClass

    @Inject
    @Named("sign_up_view_class")
    lateinit var signUpViewClass: NavigationableScreenClass

    protected open fun goToLoginView() = appNavigation.goToNextView(loginInViewClass)

    protected open fun goToSignUpView() = appNavigation.goToNextView(signUpViewClass)
}