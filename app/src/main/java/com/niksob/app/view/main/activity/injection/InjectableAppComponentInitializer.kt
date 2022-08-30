package com.niksob.app.view.main.activity.injection

import com.niksob.di.component.application.DaggerApplicationComponent

open class InjectableAppComponentInitializer : InjectableMainActivity() {

    protected open val injectableAppComponentBuilder: DaggerApplicationComponent.Builder
        get() = DaggerApplicationComponent.builder()
}