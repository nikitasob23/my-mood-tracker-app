package com.niksob.di.component

import com.niksob.di.module.view.login.SignUpViewModule
import com.niksob.presentation.view.SignUpView
import dagger.Component

@Component(modules = [SignUpViewModule::class])
interface SignUpViewComponent {
    fun inject(loginInView: SignUpView)
}