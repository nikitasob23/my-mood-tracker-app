package com.niksob.app.view.main

import com.niksob.app.view.main.injection.InjectableView
import com.niksob.app.view.main.mvvm.MainActivityWithStartDataLoader

class InjectedMainActivity : InjectableView, MainActivityWithStartDataLoader() {

    private val component get() = super.injectableComponentBuilder.build()

    override fun inject() = component.inject(this)
}