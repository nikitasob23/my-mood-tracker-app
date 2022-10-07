package com.niksob.data.storage.base.mood.tag.saving

import com.niksob.data.storage.base.mood.tag.loading.LoadableMoodTagStorage
import com.niksob.domain.model.Query

interface UpdatableMoodTagStorage : LoadableMoodTagStorage {

    fun save(request: Query)
}
