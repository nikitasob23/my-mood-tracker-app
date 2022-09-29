package com.niksob.app.view.auth.signup.viewmodel.signup

import androidx.lifecycle.Observer
import com.niksob.di.component.view.auth.signup.DaggerSignUpViewComponent
import com.niksob.di.module.viewmodel.auth.signup.SignUpViewModelWithAuthObserverModule
import com.niksob.domain.model.Query

open class InjectableMVVMSignUpView : MVVMSignUpView() {

    override val injectableComponentBuilder: DaggerSignUpViewComponent.Builder
        get() = super.injectableComponentBuilder
            .signUpViewModelWithAuthObserverModule(signUpViewModelWithAuthObserverModule)

    private val signUpViewModelWithAuthObserverModule
        get() = SignUpViewModelWithAuthObserverModule(
            authObserver = authObserver,
            lifecycleOwner = this,
        )

    private val authObserver
        get() = Observer<Query> { response ->
            onSignUpCompleted(response)
        }
}