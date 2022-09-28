package com.niksob.app.view.moodentrieslist.viewmodel.startdataloader

import com.niksob.di.component.view.moodentry.MoodEntriesListViewComponent

open class InjectedMoodEntriesListViewWithEntriesLoaderWithStartDataLoader : MoodEntriesListViewWithStartDataLoaderWithEntriesLoader() {

    override val injectableComponent: MoodEntriesListViewComponent
        get() = super.injectableComponentBuilder.build()

    override fun inject() = injectableComponent.inject(this)
}