package com.niksob.app.view.auth.login.navigation

import com.niksob.di.component.view.auth.login.DaggerLoginViewComponent
import com.niksob.di.module.app.ContextModule

open class InjectableNavigatableLoginView : LoginViewWithNavigatableBtns() {

    override val injectableComponentBuilder: DaggerLoginViewComponent.Builder
        get() = super.injectableComponentBuilder
            .contextModule(contextModule)

    private val contextModule get() = ContextModule(requireContext().applicationContext)
}