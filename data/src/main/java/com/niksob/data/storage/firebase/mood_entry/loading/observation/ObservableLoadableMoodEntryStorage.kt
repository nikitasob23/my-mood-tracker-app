package com.niksob.data.storage.firebase.mood_entry.loading.observation

import io.reactivex.Single

interface ObservableLoadableMoodEntryStorage<T : Any, U : Any> {

    fun loadByDateInterval(dto: T): Single<U>

    fun loadById(dto: T): Single<U>
}