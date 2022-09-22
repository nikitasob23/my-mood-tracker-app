package com.niksob.app.view.auth.login.navigation

import com.niksob.di.component.view.auth.login.LoginViewComponent

open class InjectedNavigatableLoginView : InjectableNavigatableLoginView() {

    override val injectableComponent: LoginViewComponent
        get() = super.injectableComponentBuilder.build()

    override fun inject() {
        super.inject()
        injectableComponent.inject(this)
    }
}