package com.niksob.app.view.base.viewmodel.mood_entry

import com.niksob.app.view.base.logger.LoggableView
import com.niksob.app.viewmodel.mood_entry.base.MoodEntriesListViewModel
import com.niksob.domain.model.Query
import javax.inject.Inject

abstract class MoodEntriesLoaderView : LoggableView() {

    @Inject
    lateinit var moodEntriesViewModel: MoodEntriesListViewModel

    protected open fun loadMoodEntriesByUserId() =
        loadData {
            moodEntriesViewModel.loadMoodEntriesByUserId()
        }

    protected open fun onLoadMoodEntriesListCompleted(response: Query) = onDataLoaded(response) { }

    override fun onCreateViewDataLoading() {
        super.onCreateViewDataLoading()
        loadMoodEntriesByUserId()
    }
}