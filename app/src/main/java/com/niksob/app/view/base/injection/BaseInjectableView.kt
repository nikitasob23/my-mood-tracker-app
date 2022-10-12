package com.niksob.app.view.base.injection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.niksob.app.view.base.ui_components.BaseViewWithUIComponentsInitializer
import com.niksob.di.component.base.InjectableComponent

abstract class BaseInjectableView : InjectableWithComponent, BaseViewWithUIComponentsInitializer() {

    override val injectableComponent: InjectableComponent? get() = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        rootView = super.onCreateView(inflater, container, savedInstanceState)
        inject()
        return rootView
    }

    override fun inject() = Unit
}