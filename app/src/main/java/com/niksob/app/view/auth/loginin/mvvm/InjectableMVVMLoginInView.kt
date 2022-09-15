package com.niksob.app.view.auth.loginin.mvvm

import androidx.lifecycle.Observer
import com.niksob.di.component.view.auth.loginin.AppLoginInViewComponent
import com.niksob.di.component.view.auth.loginin.DaggerAppLoginInViewComponent
import com.niksob.di.module.view.auth.loginin.LoginInViewModelWithObserverModule
import com.niksob.domain.model.Query

open class InjectableMVVMLoginInView : MVVMLoginInView() {

    override val injectableComponentBuilder: DaggerAppLoginInViewComponent.Builder
        get() = super.injectableComponentBuilder
            .loginInViewModelWithObserverModule(loginInViewModule)

    protected open val injectableComponent: AppLoginInViewComponent
        get() = injectableComponentBuilder.build()

    private val loginInViewModule
        get() = LoginInViewModelWithObserverModule(
            lifecycleOwner = this,
            loginInViewModelObserver = loginInViewModelObserver,
        )

    private val loginInViewModelObserver
        get() = Observer<Query> { response ->
            onCompletedLoginIn(response)
        }

    override fun inject() {
        super.inject()
        injectableComponent.inject(this)
    }
}