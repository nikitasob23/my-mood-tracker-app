package com.niksob.domain.data.repository.mood_entry.observation.loading

import io.reactivex.Single

interface ObservableLoadableMoodEntryRepository<T : Any, U : Any> {

    fun loadByDateInterval(dto: T): Single<U>

    fun loadById(dto: T): Single<U>
}