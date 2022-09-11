package com.niksob.app.view.auth.login

import com.niksob.di.component.view.auth.login.DaggerAppLoginViewComponent
import com.niksob.di.module.app.ContextModule

open class InjectableNavigatableLoginView : LoginViewWithNavigatableBtns() {

    override val injectableComponentBuilder: DaggerAppLoginViewComponent.Builder
        get() = super.injectableComponentBuilder
            .contextModule(contextModule)

    private val contextModule get() = ContextModule(requireContext().applicationContext)
}