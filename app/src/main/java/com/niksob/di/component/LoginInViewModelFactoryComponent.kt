package com.niksob.di.component

import com.niksob.di.module.FirebaseModule
import com.niksob.di.module.LoginInViewModule
import com.niksob.presentation.view.LoginInView
import dagger.Component

@Component(modules = [LoginInViewModule::class, FirebaseModule::class])
interface LoginInViewModelFactoryComponent {
    fun inject(loginInView: LoginInView)
}