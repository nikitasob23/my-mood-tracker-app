package com.niksob.app.view.main.activity.mvvm

import androidx.lifecycle.Observer
import com.niksob.di.component.view.main.DaggerMainActivityComponent
import com.niksob.di.module.view.main.AppMainActivityViewModelWithObserverModule
import com.niksob.domain.model.Query

open class InjectableMVVMMainActivity : MVVMMainActivity() {

    override val injectableComponentBuilder: DaggerMainActivityComponent.Builder
        get() = super.injectableComponentBuilder
            .appMainActivityViewModelWithObserverModule(appMainActivityViewModelWithObserverModule)

    private val appMainActivityViewModelWithObserverModule
        get() = AppMainActivityViewModelWithObserverModule(
            lifecycleOwner = this,
            authUserResponseObserver = authUserResponseObserver,
            signOutResponseObserver = signOutResponseObserver,
        )

    private val authUserResponseObserver get() = Observer<Query> { response -> onAuthUserResponseLoaded(response) }

    private val signOutResponseObserver get() = Observer<Query> { response -> onSignOutResponseLoaded(response) }
}