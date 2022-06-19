package com.niksob.data.storage.db

import com.niksob.domain.model.Query

interface MoodEntryStorage {
    fun loadByUserIdAndDate(requestDto: Query)

    fun save(request: Query)
}