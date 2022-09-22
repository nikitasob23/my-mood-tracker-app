package com.niksob.app.view.auth.signup.uicomponent

import com.niksob.di.component.view.auth.signup.SignUpViewComponent

open class InjectedSignUpViewWithSignUpComponent : SignUpViewWithSignUpComponent() {

    override val injectableComponent: SignUpViewComponent
        get() = injectableComponentBuilder.build()

    override fun inject() {
        super.inject()
        injectableComponent.inject(this)
    }
}