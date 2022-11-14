package com.niksob.data.storage.firebase.mood_entry.saving.observation

import com.niksob.data.storage.firebase.mood_entry.loading.observation.ObservableLoadableMoodEntryStorage
import io.reactivex.Completable

interface ObservableUpdatableMoodEntryStorage<T : Any, U : Any> : ObservableLoadableMoodEntryStorage<T, U> {
    fun save(dto: T): Completable
}