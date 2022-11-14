package com.niksob.data.repository.mood_entry.observation.saving

import com.niksob.data.repository.mood_entry.observation.loading.ObservableLoadableMoodEntryRepositoryImpl
import com.niksob.data.storage.firebase.mood_entry.saving.observation.ObservableUpdatableMoodEntryStorage
import com.niksob.domain.data.repository.mood_entry.observation.saving.ObservableUpdatableMoodEntryRepository

class ObservableUpdatableMoodEntryRepositoryImpl<T : Any, U : Any>(
    private val storage: ObservableUpdatableMoodEntryStorage<T, U>,
) : ObservableUpdatableMoodEntryRepository<T, U>,
    ObservableLoadableMoodEntryRepositoryImpl<T, U>(storage) {

    override fun save(dto: T) =
        storage.save(dto)
}