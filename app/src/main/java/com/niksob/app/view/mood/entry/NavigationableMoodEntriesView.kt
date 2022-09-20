package com.niksob.app.view.mood.entry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.niksob.app.view.base.inject.Injectable
import com.niksob.di.component.view.DaggerNavigationInjectionComponent
import com.niksob.di.component.view.NavigationInjectionComponent
import com.niksob.di.module.app.ContextModule

open class NavigationableMoodEntriesView : Injectable, MoodEntriesView() {

    protected open val injectableComponentBuilder: DaggerNavigationInjectionComponent.Builder
        get() = DaggerNavigationInjectionComponent.builder()
            .contextModule(contextModule)

    protected open val injectableComponent: NavigationInjectionComponent get() = injectableComponentBuilder.build()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        inject()
        return rootView
    }

    override fun inject() {
        navigation = injectableComponent.getNavigation()
    }

    private val contextModule get() = ContextModule(context = requireContext().applicationContext)
}