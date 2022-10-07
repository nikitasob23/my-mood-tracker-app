package com.niksob.app.view.auth.signup.viewmodel.useraddition

import androidx.lifecycle.Observer
import com.niksob.di.component.view.auth.signup.DaggerSignUpViewComponent
import com.niksob.di.module.viewmodel.user.UserAdditionViewModelWithObserverModule
import com.niksob.domain.model.Query

open class InjectableMVVMSignUpWithUserAdderView : MVVMSignUpWithUserAdderView() {

    override val injectableComponentBuilder: DaggerSignUpViewComponent.Builder
        get() = super.injectableComponentBuilder
            .userAdditionViewModelWithObserverModule(userAdditionViewModelWithObserverModule)

    private val userAdditionViewModelWithObserverModule
        get() = UserAdditionViewModelWithObserverModule(
            lifecycleOwner = this,
            userAdditionObserver = userAdditionObserver,
        )

    private val userAdditionObserver
        get() = Observer<Query> { response ->
            onAddUserCompleted(response)
        }
}