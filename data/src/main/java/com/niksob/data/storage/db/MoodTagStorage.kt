package com.niksob.data.storage.db

import com.niksob.domain.model.Query

interface MoodTagStorage {

    fun loadByUserIdAndDate(request: Query)

    fun save(request: Query)
}
