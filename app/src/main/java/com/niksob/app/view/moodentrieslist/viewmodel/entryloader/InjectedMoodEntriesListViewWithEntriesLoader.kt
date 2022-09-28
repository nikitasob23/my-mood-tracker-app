package com.niksob.app.view.moodentrieslist.viewmodel.entryloader

import androidx.lifecycle.Observer
import com.niksob.di.component.view.moodentry.DaggerMoodEntriesListViewComponent
import com.niksob.di.module.viewmodel.moodentry.MoodEntriesListViewWithEntriesLoaderObserverModule
import com.niksob.domain.model.Query

open class InjectedMoodEntriesListViewWithEntriesLoader : MoodEntriesListViewWithEntriesLoader() {

    override val injectableComponentBuilder: DaggerMoodEntriesListViewComponent.Builder
        get() = super.injectableComponentBuilder
            .moodEntriesListViewWithEntriesLoaderObserverModule(
                moodEntriesListViewWithEntriesLoaderObserverModule
            )

    private val moodEntriesListViewWithEntriesLoaderObserverModule
        get() = MoodEntriesListViewWithEntriesLoaderObserverModule(
            moodEntriesObserver = moodEntriesObserver,
            lifecycleOwner = this,
        )

    private val moodEntriesObserver
        get() = Observer<Query> { response ->
            onLoadMoodEntriesCompleted(response)
        }
}