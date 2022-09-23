package com.niksob.app.view.main.activity.base.app.injection

import com.niksob.app.view.main.activity.base.injection.InjectableMainActivity
import com.niksob.di.component.application.DaggerApplicationComponent

open class InjectableAppComponentInitializer : InjectableMainActivity() {

    protected open val injectableAppComponentBuilder: DaggerApplicationComponent.Builder
        get() = DaggerApplicationComponent.builder()
}