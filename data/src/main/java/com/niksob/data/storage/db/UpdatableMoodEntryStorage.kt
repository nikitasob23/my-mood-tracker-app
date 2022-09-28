package com.niksob.data.storage.db

import com.niksob.domain.model.Query

interface UpdatableMoodEntryStorage : LoadableMoodEntryStorage {

    fun save(request: Query)
}