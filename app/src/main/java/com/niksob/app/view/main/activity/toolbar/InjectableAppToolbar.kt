package com.niksob.app.view.main.activity.toolbar

import com.niksob.di.component.application.DaggerApplicationComponent
import com.niksob.di.module.app.AppToolbarModule

open class InjectableAppToolbar : MainActivityWithToolbar() {

    override val injectableAppComponentBuilder: DaggerApplicationComponent.Builder
        get() = super.injectableAppComponentBuilder
            .appToolbarModule(appToolbarModule)

    private val appToolbarModule get() = AppToolbarModule(appToolbar)
}