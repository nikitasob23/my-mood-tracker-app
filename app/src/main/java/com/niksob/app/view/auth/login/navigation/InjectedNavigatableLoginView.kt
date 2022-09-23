package com.niksob.app.view.auth.login.navigation

import com.niksob.app.view.auth.login.uicomponent.LoginViewWithNavigatableBtns
import com.niksob.di.component.view.auth.login.DaggerLoginViewComponent
import com.niksob.di.component.view.auth.login.LoginViewComponent
import com.niksob.di.module.app.ContextModule

open class InjectedNavigatableLoginView : LoginViewWithNavigatableBtns() {

    override val injectableComponentBuilder: DaggerLoginViewComponent.Builder
        get() = super.injectableComponentBuilder
            .contextModule(contextModule)

    override val injectableComponent: LoginViewComponent
        get() = injectableComponentBuilder.build()

    override fun inject() {
        super.inject()
        injectableComponent.inject(this)
    }

    private val contextModule get() = ContextModule(requireContext().applicationContext)
}