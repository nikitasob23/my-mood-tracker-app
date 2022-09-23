package com.niksob.app.view.main.activity.viewmodel.authloader.injection

import androidx.lifecycle.Observer
import com.niksob.app.view.main.activity.viewmodel.authloader.AuthLoaderMainActivity
import com.niksob.di.component.view.main.DaggerMainActivityComponent
import com.niksob.di.module.viewmodel.main.MainActivityViewModelWithObserverModule
import com.niksob.domain.model.Query

open class InjectableAuthLoaderMainActivity : AuthLoaderMainActivity() {

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