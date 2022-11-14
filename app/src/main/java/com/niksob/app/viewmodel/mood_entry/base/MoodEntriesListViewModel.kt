package com.niksob.app.viewmodel.mood_entry.base

import androidx.lifecycle.LiveData
import com.niksob.domain.model.Query

interface MoodEntriesListViewModel {

    val moodEntriesResponse: LiveData<Query>

    fun loadMoodEntriesByUserId()

    fun onLoadMoodEntriesListCompleted(response: Query)
}