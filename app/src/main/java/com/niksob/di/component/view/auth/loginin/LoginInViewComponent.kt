package com.niksob.di.component.view.auth.loginin

import com.niksob.app.view.auth.loginin.mvvm.InjectableMVVMLoginInView
import com.niksob.app.view.auth.loginin.logger.InjectableLoggableLoginInView
import com.niksob.app.view.auth.loginin.progressbar.InjectableLoginInViewWithProgressBar
import com.niksob.app.view.auth.loginin.toast.InjectableLoginInViewWithToastMessages
import com.niksob.di.component.base.InjectableComponent
import com.niksob.di.module.progressbar.AppProgressBarFromContextModule
import com.niksob.di.module.toast.ShortToastMessageModule
import com.niksob.di.module.view.auth.loginin.navigation.NavigatableLoginInViewModule
import com.niksob.di.module.viewmodel.auth.loginin.LoginInViewModelWithObserverModule
import dagger.Component

@Component(modules = [
    LoginInViewModelWithObserverModule::class,
    NavigatableLoginInViewModule::class,
    AppProgressBarFromContextModule::class,
    ShortToastMessageModule::class,
])
interface LoginInViewComponent : InjectableComponent {
    fun inject(loginInView: InjectableMVVMLoginInView)

    fun inject(loginInView: InjectableLoginInViewWithProgressBar)

    fun inject(loginInView: InjectableLoggableLoginInView)

    fun inject(loginInView: InjectableLoginInViewWithToastMessages)
}