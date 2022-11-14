package com.niksob.data.storage.firebase.mood_tag.saving.observation

import com.niksob.data.model.Request
import com.niksob.data.storage.firebase.base.loader.FirebaseStorageLoader
import com.niksob.data.storage.firebase.base.loader.database_query_factory.FirebaseQueryFactory
import com.niksob.data.storage.firebase.base.saver.FirebaseStorageSaver
import com.niksob.data.storage.firebase.mood_tag.loading.observation.ObservableLoadableMoodTagStorageImpl
import io.reactivex.Completable

class ObservableUpdatableMoodTagStorageImpl<T : Any, U : Any>(
    private val saver: FirebaseStorageSaver,
    loader: FirebaseStorageLoader<U>,
    loadByEntryIdQueryFactory: FirebaseQueryFactory,
) : ObservableUpdatableMoodTagStorage<T, U>,
    ObservableLoadableMoodTagStorageImpl<T, U>(loader, loadByEntryIdQueryFactory) {

    override fun save(dto: T) =
        Completable.create { emitter ->

            val request = Request(
                data = dto,
                callback = onDataCompletedAction(emitter)
            )
            saver.save(request)
        }
}