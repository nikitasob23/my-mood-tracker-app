package com.niksob.di.component.view.auth.login

import com.niksob.app.view.auth.login.navigation.InjectedNavigatableLoginView
import com.niksob.di.component.InjectableComponent
import com.niksob.di.module.navigation.AppScreenNavigationWithNavScreenClassModule
import com.niksob.di.module.view.auth.login.LoginViewModule
import dagger.Component

@Component(
    modules = [
        LoginViewModule::class,
        AppScreenNavigationWithNavScreenClassModule::class,
    ]
)
interface LoginViewComponent : InjectableComponent {
    fun inject(loginView: InjectedNavigatableLoginView)
}