package com.niksob.app.view.mood.entry.list.navigation

import com.niksob.di.component.view.moodentry.DaggerAppMoodEntriesListViewComponent
import com.niksob.di.module.app.ContextModule


open class InjectableNavigatableMoodEntriesListView : NavigatableMoodEntriesListView() {

    override val injectableComponentBuilder: DaggerAppMoodEntriesListViewComponent.Builder
        get() = super.injectableComponentBuilder
            .contextModule(contextModule)

    private val contextModule get() = ContextModule(requireContext().applicationContext)
}