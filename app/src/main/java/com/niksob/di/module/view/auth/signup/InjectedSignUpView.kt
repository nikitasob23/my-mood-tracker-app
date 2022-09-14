package com.niksob.di.module.view.auth.signup

import com.niksob.app.view.auth.signup.SignUpViewWithSignComponent
import com.niksob.di.component.view.auth.signup.AppSignUpViewComponent

class InjectedSignUpView : SignUpViewWithSignComponent() {

    private val injectableComponent: AppSignUpViewComponent
        get() = injectableComponentBuilder.build()

    override fun inject() {
        super.inject()
        injectableComponent.inject(this)
    }
}