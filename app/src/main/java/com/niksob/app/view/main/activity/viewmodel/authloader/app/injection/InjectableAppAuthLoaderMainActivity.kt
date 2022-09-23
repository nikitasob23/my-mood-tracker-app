package com.niksob.app.view.main.activity.viewmodel.authloader.app.injection

import com.niksob.app.view.main.activity.viewmodel.authloader.injection.InjectableAuthLoaderMainActivity
import com.niksob.di.module.app.MainActivityViewModelStoreOwnerModule
import com.niksob.di.component.application.DaggerApplicationComponent

open class InjectableAppAuthLoaderMainActivity : InjectableAuthLoaderMainActivity() {

    override val injectableAppComponentBuilder: DaggerApplicationComponent.Builder
        get() = super.injectableAppComponentBuilder
            .mainActivityViewModelStoreOwnerModule(mainActivityViewModelStoreOwnerModule)

    private val mainActivityViewModelStoreOwnerModule
        get() = MainActivityViewModelStoreOwnerModule(
            viewModelStoreOwner = this,
        )
}