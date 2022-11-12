package com.niksob.data.repository.mood_entry.observation.loading

import com.niksob.data.storage.firebase.mood_entry.loading.observation.ObservableLoadableMoodEntryStorage
import com.niksob.domain.data.repository.mood_entry.observation.loading.ObservableLoadableMoodEntryRepository

open class ObservableLoadableMoodEntryRepositoryImpl<T : Any, U : Any>(
    private val storage: ObservableLoadableMoodEntryStorage<T, U>,
) : ObservableLoadableMoodEntryRepository<T, U> {

    override fun loadByDateInterval(dto: T) =
        storage.loadByDateInterval(dto)

    override fun loadById(dto: T) =
        storage.loadById(dto)
}