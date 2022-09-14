package com.niksob.di.component.view.auth.signup

import com.niksob.di.module.navigation.AppScreenNavigationModule2
import com.niksob.di.module.view.auth.signup.InjectedSignUpView
import com.niksob.di.module.view.auth.signup.SignUpViewWithAdditionUserObserverModule
import dagger.Component

@Component(modules = [
    SignUpViewWithAdditionUserObserverModule::class,
    AppScreenNavigationModule2::class,
])
interface AppSignUpViewComponent {
    fun inject(signUpView: InjectedSignUpView)
}