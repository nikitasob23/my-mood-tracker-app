package com.niksob.app.view.auth.loginin.mvvm

import androidx.lifecycle.Observer
import com.niksob.di.component.view.auth.loginin.LoginInViewComponent
import com.niksob.di.component.view.auth.loginin.DaggerLoginInViewComponent
import com.niksob.di.module.viewmodel.auth.loginin.LoginInViewModelWithObserverModule
import com.niksob.domain.model.Query

open class InjectableMVVMLoginInView : MVVMLoginInView() {

    override val injectableComponentBuilder: DaggerLoginInViewComponent.Builder
        get() = super.injectableComponentBuilder
            .loginInViewModelWithObserverModule(loginInViewModule)

    override val injectableComponent: LoginInViewComponent
        get() = injectableComponentBuilder.build()

    private val loginInViewModule
        get() = LoginInViewModelWithObserverModule(
            lifecycleOwner = this,
            loginInViewModelObserver = loginInViewModelObserver,
        )

    private val loginInViewModelObserver
        get() = Observer<Query> { response ->
            onLoginInCompleted(response)
        }

    override fun inject() {
        super.inject()
        injectableComponent.inject(this)
    }
}