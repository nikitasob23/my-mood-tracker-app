package com.niksob.app.view.main.activity.navigation.app.injection

import com.niksob.app.view.main.activity.navigation.NavigatableMainActivity
import com.niksob.di.module.app.FragmentManagerModule
import com.niksob.di.component.application.DaggerApplicationComponent

open class InjectableAppNavigationInitializer : NavigatableMainActivity() {

    override val injectableAppComponentBuilder: DaggerApplicationComponent.Builder
        get() = super.injectableAppComponentBuilder
            .fragmentManagerModule(fragmentManagerModule)

    private val fragmentManagerModule get() = FragmentManagerModule(supportFragmentManager)
}