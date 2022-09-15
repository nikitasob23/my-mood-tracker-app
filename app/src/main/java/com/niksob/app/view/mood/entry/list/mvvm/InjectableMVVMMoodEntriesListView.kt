package com.niksob.app.view.mood.entry.list.mvvm

import androidx.lifecycle.Observer
import com.niksob.di.component.view.moodentry.DaggerAppMoodEntriesListViewComponent
import com.niksob.di.module.view.moodentry.AppMoodEntriesListViewWithMVVMObserverModule
import com.niksob.domain.model.Query

open class InjectableMVVMMoodEntriesListView : MVVMMoodEntriesListView() {

    override val injectableComponentBuilder: DaggerAppMoodEntriesListViewComponent.Builder
        get() = super.injectableComponentBuilder
            .appMoodEntriesListViewWithMVVMObserverModule(
                appMoodEntriesListViewWithMVVMObserverModule
            )

    private val appMoodEntriesListViewWithMVVMObserverModule
        get() = AppMoodEntriesListViewWithMVVMObserverModule(
            moodEntriesObserver = moodEntriesObserver,
            lifecycleOwner = this,
        )

    private val moodEntriesObserver
        get() = Observer<Query> { response ->
            onLoadMoodEntriesCompleted(response)
        }
}