package com.niksob.app.view.base.inject

import com.niksob.di.component.base.InjectableComponent

interface InjectableWithComponent {

    val injectableComponent: InjectableComponent?

    fun inject()
}