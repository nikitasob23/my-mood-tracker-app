package com.niksob.di.component.view.auth

import com.niksob.di.module.view.login.LoginViewModule
import com.niksob.app.view.auth.LoginView
import dagger.Component

@Component(modules = [LoginViewModule::class])
interface LoginViewComponent {
    fun inject(view: LoginView)
}