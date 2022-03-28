package com.niksob.di.component

import com.niksob.di.module.app.ContextModule
import com.niksob.di.module.storage.FirebaseModule
import com.niksob.di.module.viewmodel.LoginInViewModule
import com.niksob.presentation.view.LoginInView
import dagger.Component

@Component(modules = [LoginInViewModule::class, FirebaseModule::class, ContextModule::class])
interface LoginInViewModelComponent {
    fun inject(loginInView: LoginInView)
}