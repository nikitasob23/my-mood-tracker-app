package com.niksob.app.view.auth.signup

import androidx.lifecycle.Observer
import com.niksob.di.component.view.auth.signup.DaggerAppSignUpViewComponent
import com.niksob.di.module.view.auth.signup.SignUpViewWithAuthObserverModule
import com.niksob.domain.model.Query

open class InjectableMVVMSignUpView : MVVMSignUpView() {

    override val injectableComponentBuilder: DaggerAppSignUpViewComponent.Builder
        get() = super.injectableComponentBuilder
            .signUpViewWithAuthObserverModule(signUpViewWithMVVMObserverModule)

    private val signUpViewWithMVVMObserverModule
        get() = SignUpViewWithAuthObserverModule(
            authObserver = authObserver,
            lifecycleOwner = this,
        )

    private val authObserver
        get() = Observer<Query> { response ->
            onSignUpCompleted(response)
        }
}