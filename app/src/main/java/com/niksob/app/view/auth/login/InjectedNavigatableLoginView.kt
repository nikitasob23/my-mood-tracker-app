package com.niksob.app.view.auth.login

import com.niksob.di.component.view.auth.login.AppLoginViewComponent

open class InjectedNavigatableLoginView : InjectableNavigatableLoginView() {

    protected open val injectableComponent: AppLoginViewComponent
        get() = super.injectableComponentBuilder.build()

    override fun inject() {
        super.inject()
        injectableComponent.inject(this)
    }
}