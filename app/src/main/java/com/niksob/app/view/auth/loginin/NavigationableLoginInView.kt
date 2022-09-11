package com.niksob.app.view.auth.loginin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.niksob.app.view.Injectable
import com.niksob.di.component.view.DaggerNavigationInjectionComponent
import com.niksob.di.module.app.ContextModule

class NavigationableLoginInView : Injectable, LoginInView() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        inject()
        return rootView
    }

    override fun inject() {
        navigation = DaggerNavigationInjectionComponent.builder()
            .contextModule(contextModule)
            .build()
            .getNavigation()
    }

    private val contextModule get() = ContextModule(context = requireContext().applicationContext)
}