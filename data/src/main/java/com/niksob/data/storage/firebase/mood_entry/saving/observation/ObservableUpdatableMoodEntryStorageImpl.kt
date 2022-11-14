package com.niksob.data.storage.firebase.mood_entry.saving.observation

import com.niksob.data.model.Request
import com.niksob.data.storage.firebase.base.loader.FirebaseStorageLoader
import com.niksob.data.storage.firebase.base.loader.database_query_factory.FirebaseQueryFactory
import com.niksob.data.storage.firebase.base.saver.FirebaseStorageSaver
import com.niksob.data.storage.firebase.mood_entry.loading.observation.ObservableLoadableMoodEntryStorageImpl
import io.reactivex.Completable

open class ObservableUpdatableMoodEntryStorageImpl<T : Any, U : Any>(
    private val saver: FirebaseStorageSaver,
    loader: FirebaseStorageLoader<U>,
    loadByDateIntervalQueryFactory: FirebaseQueryFactory,
    loadByIdQueryFactory: FirebaseQueryFactory,
) : ObservableUpdatableMoodEntryStorage<T, U>,
    ObservableLoadableMoodEntryStorageImpl<T, U>(loader, loadByIdQueryFactory, loadByDateIntervalQueryFactory) {

    override fun save(dto: T) =
        Completable.create { emitter ->

            val request = Request(
                data = dto,
                callback = onDataCompletedAction(emitter)
            )
            saver.save(request)
        }
}