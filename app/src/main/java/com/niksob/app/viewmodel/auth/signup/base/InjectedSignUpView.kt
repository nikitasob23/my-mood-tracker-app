package com.niksob.app.viewmodel.auth.signup.base

import com.niksob.app.view.auth.signup.SignUpViewWithSignComponent
import com.niksob.di.component.view.auth.signup.SignUpViewComponent

class InjectedSignUpView : SignUpViewWithSignComponent() {

    override val injectableComponent: SignUpViewComponent
        get() = injectableComponentBuilder.build()

    override fun inject() {
        super.inject()
        injectableComponent.inject(this)
    }
}