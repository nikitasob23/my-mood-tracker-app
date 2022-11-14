package com.niksob.domain.data.repository.mood_tag.observation.saving

import com.niksob.domain.data.repository.mood_tag.observation.loading.ObservableLoadableMoodTagRepository
import io.reactivex.Completable

interface ObservableUpdatableMoodTagRepository<T : Any, U : Any> : ObservableLoadableMoodTagRepository<T, U> {
    fun save(dto: T): Completable
}