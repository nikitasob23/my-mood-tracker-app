package com.niksob.di.component.view.auth.signup

import com.niksob.di.component.InjectableComponent
import com.niksob.app.viewmodel.auth.signup.base.InjectedSignUpView
import com.niksob.di.module.view.auth.signup.navigation.SignUpViewWithNavigationModule
import com.niksob.di.module.viewmodel.signup.SignUpViewModelWithNewUserObserverModule
import dagger.Component

@Component(modules = [
    SignUpViewModelWithNewUserObserverModule::class,
    SignUpViewWithNavigationModule::class,
])
interface SignUpViewComponent : InjectableComponent {
    fun inject(signUpView: InjectedSignUpView)
}