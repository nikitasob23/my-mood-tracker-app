package com.niksob.domain.data.repository.mood_entry

import com.niksob.domain.model.Query

interface MoodEntryRepository {
    fun loadByUserIdAndDate(request: Query)
}
