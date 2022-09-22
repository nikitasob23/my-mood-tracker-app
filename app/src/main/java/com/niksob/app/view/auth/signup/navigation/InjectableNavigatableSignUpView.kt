package com.niksob.app.view.auth.signup.navigation

import com.niksob.di.component.view.auth.signup.DaggerSignUpViewComponent
import com.niksob.di.module.app.ContextModule

open class InjectableNavigatableSignUpView : NavigatableSignUpView() {

    override val injectableComponentBuilder: DaggerSignUpViewComponent.Builder
        get() = super.injectableComponentBuilder
            .contextModule(contextModule)

    private val contextModule get() = ContextModule(requireContext().applicationContext)
}