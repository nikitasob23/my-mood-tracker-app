package com.niksob.data.storage.mood.entry.saving

import com.niksob.data.storage.mood.entry.loading.LoadableMoodEntryStorage
import com.niksob.domain.model.Query

interface UpdatableMoodEntryStorage : LoadableMoodEntryStorage {

    fun save(request: Query)
}