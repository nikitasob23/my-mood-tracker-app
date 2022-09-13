package com.niksob.di.component.view.auth.login

import com.niksob.app.view.auth.login.navigation.InjectedNavigatableLoginView
import com.niksob.di.module.navigation.AppScreenNavigationModule2
import com.niksob.di.module.view.auth.login.LoginViewModule2
import dagger.Component

@Component(
    modules = [
        LoginViewModule2::class,
        AppScreenNavigationModule2::class,
    ]
)
interface AppLoginViewComponent {
    fun inject(loginView: InjectedNavigatableLoginView)
}