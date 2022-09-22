package com.niksob.app.view.auth.signup.progressbar

import com.niksob.di.component.view.auth.signup.SignUpViewComponent

class InjectedSignUpViewWithProgressbar : SignUpViewWithProgressbar() {

    override val injectableComponent: SignUpViewComponent
        get() = injectableComponentBuilder.build()

    override fun inject() = injectableComponent.inject(this)
}