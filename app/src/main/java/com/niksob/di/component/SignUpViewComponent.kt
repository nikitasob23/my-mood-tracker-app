package com.niksob.di.component

import com.niksob.di.module.view.login.SignUpViewModule
import com.niksob.di.module.app.ContextModule
import com.niksob.di.module.repository.AuthRepositoryModule
import com.niksob.di.module.storage.FirebaseModule
import com.niksob.di.module.storage.StringStorageModule
import com.niksob.di.module.view.login.LoginValidationModule
import com.niksob.presentation.view.SignUpView
import dagger.Component

@Component(modules = [
    SignUpViewModule::class,
    LoginValidationModule::class,
    AuthRepositoryModule::class,
    FirebaseModule::class,
    StringStorageModule::class,
    ContextModule::class
])
interface SignUpViewComponent {
    fun inject(loginInView: SignUpView)
}