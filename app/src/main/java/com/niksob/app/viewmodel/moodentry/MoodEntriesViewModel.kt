package com.niksob.app.viewmodel.moodentry

import androidx.lifecycle.LiveData
import com.niksob.domain.model.Query

interface MoodEntriesViewModel {

    val moodEntriesResponse: LiveData<Query>

    fun loadMoodEntriesByUserId()
}
