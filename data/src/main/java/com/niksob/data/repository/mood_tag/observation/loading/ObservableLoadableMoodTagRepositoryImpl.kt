package com.niksob.data.repository.mood_tag.observation.loading

import com.niksob.data.storage.firebase.mood_tag.loading.observation.ObservableLoadableMoodTagStorage
import com.niksob.domain.data.repository.mood_tag.observation.loading.ObservableLoadableMoodTagRepository

open class ObservableLoadableMoodTagRepositoryImpl<T : Any, U : Any>(
    private val storage: ObservableLoadableMoodTagStorage<T, U>,
) : ObservableLoadableMoodTagRepository<T, U> {

    override fun loadByEntryId(dto: T) =
        storage.loadByEntryId(dto)
}