package com.niksob.data.storage.firebase.mood_tag.saving.observation

import com.niksob.data.storage.firebase.mood_tag.loading.observation.ObservableLoadableMoodTagStorage
import io.reactivex.Completable

interface ObservableUpdatableMoodTagStorage<T : Any, U : Any> : ObservableLoadableMoodTagStorage<T, U> {
    fun save(dto: T): Completable
}