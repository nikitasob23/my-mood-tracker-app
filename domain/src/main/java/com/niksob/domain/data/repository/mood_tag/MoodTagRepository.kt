package com.niksob.domain.data.repository.mood_tag

import com.niksob.domain.model.Query

interface MoodTagRepository {
    fun loadByEntryId(request: Query)
}
