package com.niksob.di.component.view.auth

import com.niksob.di.module.view.auth.signup.SignUpViewModule
import com.niksob.app.view.auth.signup.SignUpView
import dagger.Component

@Component(modules = [SignUpViewModule::class])
interface SignUpViewComponent {
    fun inject(loginInView: SignUpView)
}