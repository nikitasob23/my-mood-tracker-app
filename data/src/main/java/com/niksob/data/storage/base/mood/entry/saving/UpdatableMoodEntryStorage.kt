package com.niksob.data.storage.base.mood.entry.saving

import com.niksob.data.storage.base.mood.entry.loading.LoadableMoodEntryStorage
import com.niksob.domain.model.Query

interface UpdatableMoodEntryStorage : LoadableMoodEntryStorage {

    fun save(request: Query)
}