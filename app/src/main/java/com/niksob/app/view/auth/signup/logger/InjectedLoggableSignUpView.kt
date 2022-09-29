package com.niksob.app.view.auth.signup.logger

import com.niksob.di.component.view.auth.signup.SignUpViewComponent

open class InjectedLoggableSignUpView : LoggableSignUpView() {

    override val injectableComponent: SignUpViewComponent get() = injectableComponentBuilder.build()

    override fun inject() = injectableComponent.inject(this)
}