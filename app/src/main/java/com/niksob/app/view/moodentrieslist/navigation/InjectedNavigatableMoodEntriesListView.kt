package com.niksob.app.view.moodentrieslist.navigation

import com.niksob.di.component.view.moodentry.DaggerMoodEntriesListViewComponent
import com.niksob.di.module.app.ContextModule


open class InjectedNavigatableMoodEntriesListView : NavigatableMoodEntriesListView() {

    override val injectableComponentBuilder: DaggerMoodEntriesListViewComponent.Builder
        get() = super.injectableComponentBuilder
            .contextModule(contextModule)

    private val contextModule get() = ContextModule(requireContext().applicationContext)
}