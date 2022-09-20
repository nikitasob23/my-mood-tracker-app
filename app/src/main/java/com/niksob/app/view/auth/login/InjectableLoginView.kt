package com.niksob.app.view.auth.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.niksob.app.view.base.inject.InjectableWithComponent
import com.niksob.di.component.InjectableComponent
import com.niksob.di.component.view.auth.login.DaggerAppLoginViewComponent

open class InjectableLoginView : InjectableWithComponent, BaseLoginView() {

    protected open val injectableComponentBuilder: DaggerAppLoginViewComponent.Builder
        get() = DaggerAppLoginViewComponent.builder()

    override val injectableComponent: InjectableComponent? get() = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        inject()
        return rootView
    }

    override fun inject() = Unit
}