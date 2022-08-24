package com.niksob.app.view.main

import com.niksob.app.view.main.logging.LoggableMVVMMainActivity

class InjectedMainActivity : LoggableMVVMMainActivity() {

    private val component get() = super.injectableComponentBuilder.build()

    override fun inject() = component.inject(this)
}