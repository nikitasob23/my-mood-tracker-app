package com.niksob.app.view.auth.loginin.navigation

import com.niksob.di.component.view.auth.loginin.DaggerAppLoginInViewComponent
import com.niksob.di.module.app.ContextModule

open class InjectableNavigatableLoginInView : NavigatableLoginInView() {

    override val injectableComponentBuilder: DaggerAppLoginInViewComponent.Builder
        get() = super.injectableComponentBuilder
            .contextModule(contextModule)

    private val contextModule get() = ContextModule(requireContext().applicationContext)
}