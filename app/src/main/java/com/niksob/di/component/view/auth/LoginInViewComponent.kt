package com.niksob.di.component.view.auth

import com.niksob.di.module.view.login.LoginInViewModule
import com.niksob.app.view.auth.loginin.LoginInView
import dagger.Component

@Component(modules = [LoginInViewModule::class])
interface LoginInViewComponent {
    fun inject(loginInView: LoginInView)
}