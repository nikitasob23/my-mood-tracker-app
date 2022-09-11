package com.niksob.app.view.auth.login

import com.niksob.domain.navigation.NavigationableScreen
import com.niksob.domain.navigation.ScreenNavigation
import javax.inject.Inject
import javax.inject.Named

open class NavigatableLoginView : InjectableLoginView() {

    @Inject
    lateinit var appNavigation: ScreenNavigation

    @Inject
    @Named("provide_login_in_view_class")
    lateinit var loginInViewClass: Class<out NavigationableScreen>

    @Inject
    @Named("provide_sign_up_view_class")
    lateinit var signUpViewClass: Class<out NavigationableScreen>

    protected open fun goToLoginView() = appNavigation.goToNextView(loginInViewClass)

    protected open fun goToSignUpView() = appNavigation.goToNextView(signUpViewClass)
}