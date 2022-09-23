package com.niksob.app.view.mood.entry.list.mvvm.loadmoodentries

import com.niksob.app.view.mood.entry.list.navigation.InjectedNavigatableMoodEntriesListView
import com.niksob.app.viewmodel.moodentry.MoodEntriesViewModel
import com.niksob.domain.model.Query
import javax.inject.Inject

open class MVVMMoodEntriesListView : InjectedNavigatableMoodEntriesListView() {

    @Inject
    lateinit var moodEntriesViewModel: MoodEntriesViewModel

    protected open fun loadMoodEntriesByUserId() = moodEntriesViewModel.loadMoodEntriesByUserId()

    protected open fun onLoadMoodEntriesCompleted(response: Query) {
        if (!response.completed) {
            throw IllegalStateException()
        }
    }
}