package com.niksob.app.view.auth.signup.base

import com.niksob.di.component.view.auth.signup.DaggerSignUpViewComponent

open class InjectableSignUpView : BaseSignUpView() {

    protected open val injectableComponentBuilder: DaggerSignUpViewComponent.Builder
        get() = DaggerSignUpViewComponent.builder()
}