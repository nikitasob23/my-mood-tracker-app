package com.niksob.domain.data.repository.mood_entry.observation.saving

import com.niksob.domain.data.repository.mood_entry.observation.loading.ObservableLoadableMoodEntryRepository
import io.reactivex.Completable

interface ObservableUpdatableMoodEntryRepository<T : Any, U : Any> : ObservableLoadableMoodEntryRepository<T, U> {
    fun save(dto: T): Completable
}