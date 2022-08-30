package com.niksob.app.view.main.activity.mvvm

import com.niksob.di.module.app.MainActivityViewModelStoreOwnerModule
import com.niksob.di.component.application.DaggerApplicationComponent

open class InjectableAppMVVMMainActivity : InjectableMVVMMainActivity() {

    override val injectableAppComponentBuilder: DaggerApplicationComponent.Builder
        get() = super.injectableAppComponentBuilder
            .mainActivityViewModelStoreOwnerModule(mainActivityViewModelStoreOwnerModule)

    private val mainActivityViewModelStoreOwnerModule
        get() = MainActivityViewModelStoreOwnerModule(
            viewModelStoreOwner = this,
        )
}