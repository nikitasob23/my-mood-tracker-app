package com.niksob.data.storage.mood.tag.loading

import com.niksob.domain.model.Query

interface LoadableMoodTagStorage {
    fun loadByUserIdAndDate(request: Query)
}