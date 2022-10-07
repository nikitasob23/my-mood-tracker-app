package com.niksob.data.storage.base.mood.tag.loading

import com.niksob.domain.model.Query

interface LoadableMoodTagStorage {
    fun loadByUserIdAndDate(request: Query)
}