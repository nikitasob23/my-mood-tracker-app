package com.niksob.app.view.mood_entry_addition.viewmodel

import com.niksob.app.view.mood_entry_addition.navigation.NavigatableMoodEntryAdditionView
import com.niksob.app.viewmodel.moodentry.base.MoodEntriesListViewModel
import com.niksob.domain.model.Query
import javax.inject.Inject

open class MoodEntryLoader : NavigatableMoodEntryAdditionView() {

    @Inject
    lateinit var moodEntriesListViewModel: MoodEntriesListViewModel

    protected open fun loadMoodEntryByUserId() {
        moodEntriesListViewModel.loadMoodEntriesByUserId()
    }

    protected open fun onLoadMoodEntryCompleted(response: Query) {
        if (!response.completed) {
            throw IllegalStateException()
        }
    }
}