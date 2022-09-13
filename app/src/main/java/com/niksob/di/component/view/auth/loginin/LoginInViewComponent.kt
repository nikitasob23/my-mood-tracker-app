package com.niksob.di.component.view.auth.loginin

import com.niksob.di.module.view.auth.loginin.LoginInViewModelWithViewModelStoreOwnerModule
import com.niksob.app.view.auth.loginin.LoginInView
import dagger.Component

@Component(modules = [LoginInViewModelWithViewModelStoreOwnerModule::class])
interface LoginInViewComponent {
    fun inject(loginInView: LoginInView)
}