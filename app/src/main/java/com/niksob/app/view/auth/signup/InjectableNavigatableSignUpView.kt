package com.niksob.app.view.auth.signup

import com.niksob.di.component.view.auth.signup.DaggerAppSignUpViewComponent
import com.niksob.di.module.app.ContextModule

open class InjectableNavigatableSignUpView : NavigatableSignUpView() {

    override val injectableComponentBuilder: DaggerAppSignUpViewComponent.Builder
        get() = super.injectableComponentBuilder
            .contextModule(contextModule)

    private val contextModule get() = ContextModule(requireContext().applicationContext)
}