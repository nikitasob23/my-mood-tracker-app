package com.niksob.app.view.moodentrieslist.logger

import com.niksob.di.component.view.moodentry.MoodEntriesListViewComponent

open class InjectedLoggableMoodEntriesListViewWithEntriesLoader : LoggableMoodEntriesListViewWithEntriesLoader() {

    override val injectableComponent: MoodEntriesListViewComponent
        get() = injectableComponentBuilder.build()

    override fun inject() = injectableComponent.inject(this)
}