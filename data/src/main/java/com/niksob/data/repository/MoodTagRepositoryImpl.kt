package com.niksob.data.repository

import com.niksob.data.storage.db.MoodTagStorage
import com.niksob.domain.data.repository.MoodTagRepository
import com.niksob.domain.model.Query

class MoodTagRepositoryImpl(
    private val storage: MoodTagStorage
) : MoodTagRepository {
    override fun loadByUserIdAndDate(request: Query) {
        storage.loadByUserIdAndDate(request)
    }
}