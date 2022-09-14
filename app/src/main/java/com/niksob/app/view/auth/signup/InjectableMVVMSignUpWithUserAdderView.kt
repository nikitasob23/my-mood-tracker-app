package com.niksob.app.view.auth.signup

import androidx.lifecycle.Observer
import com.niksob.di.component.view.auth.signup.DaggerAppSignUpViewComponent
import com.niksob.di.module.view.auth.signup.SignUpViewWithAdditionUserObserverModule
import com.niksob.domain.model.Query

open class InjectableMVVMSignUpWithUserAdderView : MVVMSignUpWithUserAdderView() {

    override val injectableComponentBuilder: DaggerAppSignUpViewComponent.Builder
        get() = super.injectableComponentBuilder
            .signUpViewWithAdditionUserObserverModule(signUpViewWithAdditionUserObserverModule)

    private val signUpViewWithAdditionUserObserverModule
        get() = SignUpViewWithAdditionUserObserverModule(
            userAdditionQuery = userAdditionQuery,
            lifecycleOwner = this,
        )

    private val userAdditionQuery
        get() = Observer<Query> { response ->
            onAddUserCompleted(response)
        }
}