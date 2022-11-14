package com.niksob.data.repository.mood_tag.observation.saving

import com.niksob.data.repository.mood_tag.observation.loading.ObservableLoadableMoodTagRepositoryImpl
import com.niksob.data.storage.firebase.mood_tag.saving.observation.ObservableUpdatableMoodTagStorage
import com.niksob.domain.data.repository.mood_tag.observation.saving.ObservableUpdatableMoodTagRepository

class ObservableUpdatableMoodTagRepositoryImpl<T : Any, U : Any>(
    private val storage: ObservableUpdatableMoodTagStorage<T, U>,
) : ObservableUpdatableMoodTagRepository<T, U>,
    ObservableLoadableMoodTagRepositoryImpl<T, U>(storage) {

    override fun save(dto: T) =
        storage.save(dto)
}