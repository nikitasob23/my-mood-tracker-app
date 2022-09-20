package com.niksob.app.view.auth.login.navigation

import com.niksob.di.component.view.auth.login.AppLoginViewComponent

open class InjectedNavigatableLoginView : InjectableNavigatableLoginView() {

    override val injectableComponent: AppLoginViewComponent
        get() = super.injectableComponentBuilder.build()

    override fun inject() {
        super.inject()
        injectableComponent.inject(this)
    }
}