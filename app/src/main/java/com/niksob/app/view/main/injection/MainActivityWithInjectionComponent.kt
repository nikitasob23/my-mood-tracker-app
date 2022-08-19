package com.niksob.app.view.main.injection

import android.os.Bundle
import com.niksob.app.view.main.BaseMainActivity
import com.niksob.di.component.view.main.DaggerMainActivityComponent
import com.niksob.di.module.app.ContextModule
import com.niksob.di.module.app.FragmentManagerModule
import com.niksob.di.module.app.MainActivityViewModelStoreOwnerModule

open class MainActivityWithInjectionComponent : InjectableView, BaseMainActivity() {

    protected open val injectableComponentBuilder: DaggerMainActivityComponent.Builder
        get() = DaggerMainActivityComponent.builder()
            .contextModule(contextModule)
            .mainActivityViewModelStoreOwnerModule(mainActivityViewModelStoreOwnerModule)
            .fragmentManagerModule(fragmentManagerModule)

    private val contextModule get() = ContextModule(applicationContext)

    private val mainActivityViewModelStoreOwnerModule
        get() = MainActivityViewModelStoreOwnerModule(viewModelStoreOwner = this)

    private val fragmentManagerModule get() = FragmentManagerModule(supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    override fun inject() = Unit
}