package com.niksob.data.storage.db

import com.niksob.domain.model.Query

interface MoodEntryStorage : LoadableMoodEntryStorage {

    fun save(request: Query)
}