package com.niksob.app.view.mood.entry.list.mvvm.loadmoodentries

import com.niksob.app.view.mood.entry.list.navigation.InjectedNavigatableMoodEntriesListView
import com.niksob.app.viewmodel.moodentry.base.MoodEntriesListViewModel
import com.niksob.domain.model.Query
import javax.inject.Inject

open class MVVMMoodEntriesListView : InjectedNavigatableMoodEntriesListView() {

    @Inject
    lateinit var moodEntriesViewModel: MoodEntriesListViewModel

    protected open fun loadMoodEntriesByUserId() = moodEntriesViewModel.loadMoodEntriesByUserId()

    protected open fun onLoadMoodEntriesCompleted(response: Query) {
        if (!response.completed) {
            throw IllegalStateException()
        }
    }
}