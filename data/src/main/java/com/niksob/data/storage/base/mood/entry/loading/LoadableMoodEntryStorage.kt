package com.niksob.data.storage.base.mood.entry.loading

import com.niksob.domain.model.Query

interface LoadableMoodEntryStorage {

    fun loadByUserIdAndDate(requestDto: Query)
}