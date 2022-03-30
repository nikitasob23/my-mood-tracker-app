package com.niksob.di.component

import com.niksob.di.module.app.ContextModule
import com.niksob.di.module.repository.AuthRepositoryModule
import com.niksob.di.module.storage.FirebaseModule
import com.niksob.di.module.storage.StringStorageModule
import com.niksob.di.module.view.login.LoginInViewModule
import com.niksob.di.module.view.login.LoginValidationModule
import com.niksob.presentation.view.LoginInView
import dagger.Component

@Component(modules = [
    LoginInViewModule::class,
    LoginValidationModule::class,
    AuthRepositoryModule::class,
    FirebaseModule::class,
    StringStorageModule::class,
    ContextModule::class
])
interface LoginInViewComponent {
    fun inject(loginInView: LoginInView)
}