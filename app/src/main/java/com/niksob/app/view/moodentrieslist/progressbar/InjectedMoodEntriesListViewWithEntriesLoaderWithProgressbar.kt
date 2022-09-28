package com.niksob.app.view.moodentrieslist.progressbar

import com.niksob.di.component.view.moodentry.MoodEntriesListViewComponent

open class InjectedMoodEntriesListViewWithEntriesLoaderWithProgressbar : MoodEntriesListViewWithProgressbarWithEntriesLoader() {

    override val injectableComponent: MoodEntriesListViewComponent
        get() = injectableComponentBuilder.build()

    override fun inject() = injectableComponent.inject(this)
}