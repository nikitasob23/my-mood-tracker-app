package com.niksob.app.viewmodel.moodentry.base

import androidx.lifecycle.LiveData
import com.niksob.domain.model.Query

interface MoodEntriesListViewModel {

    val moodEntriesResponse: LiveData<Query>

    fun loadMoodEntriesByUserId()

    fun onLoadMoodEntriesListCompleted(response: Query)
}