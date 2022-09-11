package com.niksob.di.component.view.auth.login

import com.niksob.di.module.view.login.LoginViewModule
import com.niksob.app.view.auth.login.DeprecatedLoginView
import dagger.Component

@Component(modules = [LoginViewModule::class])
interface LoginViewComponent {
    fun inject(view: DeprecatedLoginView)
}