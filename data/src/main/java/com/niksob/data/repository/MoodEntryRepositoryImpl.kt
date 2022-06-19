package com.niksob.data.repository

import com.niksob.data.storage.db.MoodEntryStorage
import com.niksob.domain.data.repository.MoodEntryRepository
import com.niksob.domain.model.Query

class MoodEntryRepositoryImpl(
    private val storage: MoodEntryStorage
) : MoodEntryRepository {
    override fun loadByUserIdAndDate(request: Query) {
        storage.loadByUserIdAndDate(request)
    }
}