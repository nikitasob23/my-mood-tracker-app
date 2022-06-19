package com.niksob.domain.data.repository

import com.niksob.domain.model.Query

interface MoodEntryRepository {
    fun loadByUserIdAndDate(request: Query)
}
