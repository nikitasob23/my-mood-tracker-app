package com.niksob.app.view.main.mvvm

import androidx.lifecycle.Observer
import com.niksob.di.component.view.main.DaggerMainActivityComponent
import com.niksob.di.module.view.main.MainActivityViewModelWithObserverModule
import com.niksob.domain.model.Query

open class InjectableMVVMMainActivity : MVVMMainActivity() {

    override val injectableComponentBuilder: DaggerMainActivityComponent.Builder
        get() = super.injectableComponentBuilder
            .mainActivityViewModelWithObserverModule(mainActivityViewModelWithObserverModule)

    private val mainActivityViewModelWithObserverModule
        get() = MainActivityViewModelWithObserverModule(
            lifecycleOwner = this,
            authUserResponseObserver = authUserResponseObserver,
            signOutResponseObserver = signOutResponseObserver,
        )

    private val authUserResponseObserver get() = Observer<Query> { response -> onAuthUserResponseLoaded(response) }

    private val signOutResponseObserver get() = Observer<Query> { response -> onSignOutResponseLoaded(response) }
}