package com.niksob.data.repository.mood_entry

import com.niksob.data.storage.base.mood.entry.saving.UpdatableMoodEntryStorage
import com.niksob.domain.data.repository.mood_entry.MoodEntryRepository
import com.niksob.domain.model.Query

class MoodEntryRepositoryImpl(
    private val storage: UpdatableMoodEntryStorage
) : MoodEntryRepository {
    override fun loadByUserIdAndDate(request: Query) {
        storage.loadByUserIdAndDate(request)
    }
}