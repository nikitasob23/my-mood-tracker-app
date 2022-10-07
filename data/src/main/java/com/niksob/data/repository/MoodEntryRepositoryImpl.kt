package com.niksob.data.repository

import com.niksob.data.storage.base.mood.entry.saving.UpdatableMoodEntryStorage
import com.niksob.domain.data.repository.MoodEntryRepository
import com.niksob.domain.model.Query

class MoodEntryRepositoryImpl(
    private val storage: UpdatableMoodEntryStorage
) : MoodEntryRepository {
    override fun loadByUserIdAndDate(request: Query) {
        storage.loadByUserIdAndDate(request)
    }
}