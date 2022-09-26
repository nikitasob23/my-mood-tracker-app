package com.niksob.app.view.mood.entry.list.progressbar

import com.niksob.di.component.view.moodentry.MoodEntriesListViewComponent

open class InjectedMoodEntriesListViewWithProgressbar : MoodEntriesListViewWithProgressbar() {

    override val injectableComponent: MoodEntriesListViewComponent
        get() = injectableComponentBuilder.build()

    override fun inject() = injectableComponent.inject(this)
}