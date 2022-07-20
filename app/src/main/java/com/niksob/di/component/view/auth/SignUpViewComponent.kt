package com.niksob.di.component.view.auth

import com.niksob.di.module.view.login.SignUpViewModule
import com.niksob.app.view.auth.SignUpView
import dagger.Component

@Component(modules = [SignUpViewModule::class])
interface SignUpViewComponent {
    fun inject(loginInView: SignUpView)
}