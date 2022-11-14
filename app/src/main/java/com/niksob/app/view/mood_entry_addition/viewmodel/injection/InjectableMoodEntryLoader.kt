package com.niksob.app.view.mood_entry_addition.viewmodel.injection

import androidx.lifecycle.Observer
import com.niksob.app.view.mood_entry_addition.viewmodel.MoodEntryLoader
import com.niksob.di.component.view.mood_entry_addition.DaggerAdditionMoodEntryViewComponent
import com.niksob.di.module.viewmodel.mood_entry.MoodEntriesListViewWithEntriesLoaderObserverModule
import com.niksob.domain.model.Query

open class InjectableMoodEntryLoader : MoodEntryLoader() {

    override val injectableComponentBuilder: DaggerAdditionMoodEntryViewComponent.Builder
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
            onLoadMoodEntryCompleted(response)
        }
}