package com.niksob.data.storage.db

import com.niksob.domain.model.Query

interface LoadableMoodEntryStorage {

    fun loadByUserIdAndDate(requestDto: Query)
}