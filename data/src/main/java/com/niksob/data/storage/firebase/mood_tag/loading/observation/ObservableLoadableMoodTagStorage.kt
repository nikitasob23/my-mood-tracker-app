package com.niksob.data.storage.firebase.mood_tag.loading.observation

import io.reactivex.Single

interface ObservableLoadableMoodTagStorage<T, U> {
    fun loadByEntryId(dto: T): Single<U>
}
