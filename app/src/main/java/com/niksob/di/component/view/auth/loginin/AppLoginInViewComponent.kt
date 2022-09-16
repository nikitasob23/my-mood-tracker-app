package com.niksob.di.component.view.auth.loginin

import com.niksob.app.view.auth.loginin.mvvm.InjectableMVVMLoginInView
import com.niksob.app.view.auth.loginin.progressbar.InjectableLoggableLoginInView
import com.niksob.app.view.auth.loginin.progressbar.InjectableLoginInViewWithProgressBar
import com.niksob.di.module.app.progressbar.AppProgressBarFromContextModule
import com.niksob.di.module.navigation.AppScreenNavigationWithNavScreenClassModule
import com.niksob.di.module.view.auth.loginin.LoginInViewModelWithObserverModule
import dagger.Component

@Component(modules = [
    LoginInViewModelWithObserverModule::class,
    AppScreenNavigationWithNavScreenClassModule::class,
    AppProgressBarFromContextModule::class,
])
interface AppLoginInViewComponent {
    fun inject(loginInView: InjectableMVVMLoginInView)

    fun inject(loginInView: InjectableLoginInViewWithProgressBar)

    fun inject(loginInView: InjectableLoggableLoginInView)
}