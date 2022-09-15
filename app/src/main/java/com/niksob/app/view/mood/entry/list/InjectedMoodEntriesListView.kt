package com.niksob.app.view.mood.entry.list

import com.niksob.app.view.mood.entry.list.mvvm.MoodEntriesListViewWithStartDataLoader
import com.niksob.di.component.view.moodentry.AppMoodEntriesListViewComponent

open class InjectedMoodEntriesListView : MoodEntriesListViewWithStartDataLoader() {

    protected open val injectableComponent: AppMoodEntriesListViewComponent
        get() = injectableComponentBuilder.build()

    override fun inject() {
        super.inject()
        injectableComponent.inject(this)
    }
}