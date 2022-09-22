package com.niksob.app.view.auth.signup.toast

import com.niksob.di.component.view.auth.signup.SignUpViewComponent

open class InjectedSignUpViewWithToastMessages : SignUpViewWithToastMessages() {

    override val injectableComponent: SignUpViewComponent
        get() = injectableComponentBuilder.build()

    override fun inject() = injectableComponent.inject(this)
}