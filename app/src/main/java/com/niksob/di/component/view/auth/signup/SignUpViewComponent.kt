package com.niksob.di.component.view.auth.signup

import com.niksob.di.module.view.auth.signup.SignUpViewWithViewModelStoreOwnerModule
import com.niksob.app.view.auth.signup.SignUpView
import dagger.Component

@Component(modules = [SignUpViewWithViewModelStoreOwnerModule::class])
interface SignUpViewComponent {
    fun inject(loginInView: SignUpView)
}