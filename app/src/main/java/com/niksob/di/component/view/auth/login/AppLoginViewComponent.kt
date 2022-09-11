package com.niksob.di.component.view.auth.login

import com.niksob.app.view.auth.login.InjectedNavigatableLoginView
import com.niksob.di.module.navigation.AppScreenNavigationModule
import com.niksob.di.module.view.login.LoginViewModule
import dagger.Component

@Component(
    modules = [
        LoginViewModule::class,
        AppScreenNavigationModule::class,
    ]
)
interface AppLoginViewComponent {
    fun inject(loginView: InjectedNavigatableLoginView)
}