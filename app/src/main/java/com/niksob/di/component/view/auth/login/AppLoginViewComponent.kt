package com.niksob.di.component.view.auth.login

import com.niksob.app.view.auth.login.navigation.InjectedNavigatableLoginView
import com.niksob.di.module.navigation.AppScreenNavigationWithNavScreenClassModule
import com.niksob.di.module.view.auth.login.LoginViewModule2
import dagger.Component

@Component(
    modules = [
        LoginViewModule2::class,
        AppScreenNavigationWithNavScreenClassModule::class,
    ]
)
interface AppLoginViewComponent {
    fun inject(loginView: InjectedNavigatableLoginView)
}