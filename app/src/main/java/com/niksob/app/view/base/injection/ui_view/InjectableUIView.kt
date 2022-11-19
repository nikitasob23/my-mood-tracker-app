package com.niksob.app.view.base.injection.ui_view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.niksob.app.view.base.UIView
import com.niksob.app.view.base.injection.Injectable
import com.niksob.di.component.base.LayoutIdComponent
import com.niksob.di.component.base.InjectableComponent

abstract class InjectableUIView : Injectable, UIView() {

    protected open val injectableComponent: InjectableComponent? get() = null

    protected lateinit var injectLayoutIdViewComponent: LayoutIdComponent

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        injectLayoutId()
        super.onCreateView(inflater, container, savedInstanceState)
        inject()
        return rootView
    }

    protected open fun injectLayoutId() {
        layoutId = injectLayoutIdViewComponent.getLayoutId()
    }

    override fun inject() = Unit
}