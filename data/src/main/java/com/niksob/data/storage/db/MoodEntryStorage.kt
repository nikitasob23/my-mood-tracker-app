package com.niksob.data.storage.db

import com.niksob.domain.model.Query

interface MoodEntryStorage {
    fun loadByDate(request: Query)

    fun save(request: Query)
}