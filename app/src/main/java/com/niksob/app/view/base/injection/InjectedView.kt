package com.niksob.app.view.base.injection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.niksob.app.view.base.logger.LoggableView
import com.niksob.di.component.view.base.BaseViewComponent
import com.niksob.di.component.view.base.DaggerBaseViewComponent
import com.niksob.di.module.app.ContextModule

abstract class InjectedView : LoggableView() {

    protected open val baseViewComponent: BaseViewComponent
        get() = baseViewComponentBuilder.build()

    protected open val baseViewComponentBuilder: DaggerBaseViewComponent.Builder
        get() = DaggerBaseViewComponent.builder()
            .contextModule(contextModule)

    private val contextModule get() = ContextModule(requireContext().applicationContext)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        injectBaseView()
        return rootView
    }

    private fun injectBaseView() = baseViewComponent.inject(this)
}