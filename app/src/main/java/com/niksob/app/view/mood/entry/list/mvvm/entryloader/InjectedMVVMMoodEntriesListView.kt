package com.niksob.app.view.mood.entry.list.mvvm.entryloader

import androidx.lifecycle.Observer
import com.niksob.di.component.view.moodentry.DaggerMoodEntriesListViewComponent
import com.niksob.di.module.viewmodel.moodentry.MoodEntriesListViewWithMVVMObserverModule
import com.niksob.domain.model.Query

open class InjectedMVVMMoodEntriesListView : MVVMMoodEntriesListView() {

    override val injectableComponentBuilder: DaggerMoodEntriesListViewComponent.Builder
        get() = super.injectableComponentBuilder
            .moodEntriesListViewWithMVVMObserverModule(
                moodEntriesListViewWithMVVMObserverModule
            )

    private val moodEntriesListViewWithMVVMObserverModule
        get() = MoodEntriesListViewWithMVVMObserverModule(
            moodEntriesObserver = moodEntriesObserver,
            lifecycleOwner = this,
        )

    private val moodEntriesObserver
        get() = Observer<Query> { response ->
            onLoadMoodEntriesCompleted(response)
        }
}