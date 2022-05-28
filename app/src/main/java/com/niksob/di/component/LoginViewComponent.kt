package com.niksob.di.component

import com.niksob.di.module.view.login.LoginViewModule
import com.niksob.app.view.LoginView
import dagger.Component

@Component(modules = [LoginViewModule::class])
interface LoginViewComponent {
    fun inject(view: LoginView)
}