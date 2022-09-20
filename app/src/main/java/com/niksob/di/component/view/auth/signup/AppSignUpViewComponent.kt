package com.niksob.di.component.view.auth.signup

import com.niksob.di.component.InjectableComponent
import com.niksob.di.module.navigation.AppScreenNavigationWithNavScreenClassModule
import com.niksob.di.module.view.auth.signup.InjectedSignUpView
import com.niksob.di.module.view.auth.signup.SignUpViewWithAdditionUserObserverModule
import dagger.Component

@Component(modules = [
    SignUpViewWithAdditionUserObserverModule::class,
    AppScreenNavigationWithNavScreenClassModule::class,
])
interface AppSignUpViewComponent : InjectableComponent {
    fun inject(signUpView: InjectedSignUpView)
}