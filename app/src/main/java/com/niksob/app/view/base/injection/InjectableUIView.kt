package com.niksob.app.view.base.injection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.niksob.app.view.base.UIView
import com.niksob.di.component.base.InjectableComponent

abstract class InjectableUIView : Injectable, UIView() {

    protected open val injectableComponent: InjectableComponent? get() = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        inject()
        return rootView
    }

    override fun inject() = Unit
}