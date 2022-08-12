package com.niksob.data.storage.db

import com.niksob.domain.model.Query

interface LoadableMoodTagStorage {
    fun loadByUserIdAndDate(request: Query)
}