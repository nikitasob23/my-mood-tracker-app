package com.niksob.data.repository

import com.niksob.data.storage.base.mood.tag.saving.UpdatableMoodTagStorage
import com.niksob.domain.data.repository.MoodTagRepository
import com.niksob.domain.model.Query

class MoodTagRepositoryImpl(
    private val storage: UpdatableMoodTagStorage
) : MoodTagRepository {
    override fun loadByEntryId(request: Query) {
        storage.loadByUserIdAndDate(request)
    }
}