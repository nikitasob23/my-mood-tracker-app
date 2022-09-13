package com.niksob.di.component.view.auth.loginin

import com.niksob.app.view.auth.loginin.mvvm.InjectableMVVMLoginInView
import com.niksob.di.module.navigation.AppScreenNavigationModule2
import com.niksob.di.module.view.auth.loginin.LoginInViewModelWithObserverModule
import dagger.Component

@Component(modules = [
    LoginInViewModelWithObserverModule::class,
    AppScreenNavigationModule2::class,
])
interface AppLoginInViewComponent {
    fun inject(loginInView: InjectableMVVMLoginInView)
}