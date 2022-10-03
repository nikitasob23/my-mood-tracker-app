package com.niksob.data.storage.mood.tag.saving

import com.niksob.data.storage.mood.tag.loading.LoadableMoodTagStorage
import com.niksob.domain.model.Query

interface UpdatableMoodTagStorage : LoadableMoodTagStorage {

    fun save(request: Query)
}
