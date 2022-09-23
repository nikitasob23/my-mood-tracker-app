package com.niksob.app.view.main.activity.logging.injection

import com.niksob.app.view.main.activity.logging.app.injection.InjectedAppLoggableAuthLoaderMainActivity

class InjectedLoggableAuthLoaderMainActivity : InjectedAppLoggableAuthLoaderMainActivity() {

    private val component get() = super.injectableComponentBuilder.build()

    override fun inject() {
        super.inject()
        component.inject(this)
    }
}