package com.niksob.app.view.main.activity

import com.niksob.app.view.main.activity.injection.InjectedAppMainActivity

class InjectedMainActivity : InjectedAppMainActivity() {

    private val component get() = super.injectableComponentBuilder.build()

    override fun inject() {
        super.inject()
        component.inject(this)
    }
}