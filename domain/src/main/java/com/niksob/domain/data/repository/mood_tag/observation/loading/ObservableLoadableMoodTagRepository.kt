package com.niksob.domain.data.repository.mood_tag.observation.loading

import io.reactivex.Single

interface ObservableLoadableMoodTagRepository<T : Any, U : Any> {
    fun loadByEntryId(dto: T): Single<U>
}
