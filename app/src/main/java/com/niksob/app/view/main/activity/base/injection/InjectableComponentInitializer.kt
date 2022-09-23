package com.niksob.app.view.main.activity.base.injection

import com.niksob.app.view.main.activity.base.app.injection.InjectableAppComponentInitializer
import com.niksob.di.component.view.main.DaggerMainActivityComponent
import com.niksob.di.module.app.ContextModule

open class InjectableComponentInitializer : InjectableAppComponentInitializer() {

    protected open val injectableComponentBuilder: DaggerMainActivityComponent.Builder
        get() = DaggerMainActivityComponent.builder()
            .contextModule(contextModule)

    private val contextModule get() = ContextModule(applicationContext)
}