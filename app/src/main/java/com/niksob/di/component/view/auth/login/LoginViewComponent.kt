package com.niksob.di.component.view.auth.login

import com.niksob.app.view.auth.login.navigation.InjectedNavigatableLoginView
import com.niksob.di.component.base.InjectableComponent
import com.niksob.di.module.navigation.ScreenNavigationModule
import com.niksob.di.module.view.auth.login.LoginViewModule
import dagger.Component

@Component(
    modules = [
        LoginViewModule::class,
        ScreenNavigationModule::class,
    ]
)
interface LoginViewComponent : InjectableComponent {
    fun inject(loginView: InjectedNavigatableLoginView)
}