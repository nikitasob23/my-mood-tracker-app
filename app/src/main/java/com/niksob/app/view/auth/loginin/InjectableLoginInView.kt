package com.niksob.app.view.auth.loginin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.niksob.app.view.Injectable
import com.niksob.di.component.view.auth.loginin.DaggerAppLoginInViewComponent

open class InjectableLoginInView : Injectable, BaseLoginInView() {

    protected open val injectableComponentBuilder: DaggerAppLoginInViewComponent.Builder
        get() = DaggerAppLoginInViewComponent.builder()

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