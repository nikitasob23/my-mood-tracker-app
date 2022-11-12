package com.niksob.data.storage.firebase.mood_entry.loading.observation

import com.niksob.data.storage.firebase.base.loader.observation.BaseObservableStorage
import com.niksob.data.model.Request
import com.niksob.data.storage.firebase.base.loader.FirebaseStorageLoader
import com.niksob.data.storage.firebase.base.loader.database_query_factory.FirebaseQueryFactory
import io.reactivex.Single

open class ObservableLoadableMoodEntryStorageImpl<T : Any, U : Any>(
    private val loader: FirebaseStorageLoader<U>,
    private val loadByDateIntervalQueryFactory: FirebaseQueryFactory,
    private val loadByIdQueryFactory: FirebaseQueryFactory,
) : ObservableLoadableMoodEntryStorage<T, U>, BaseObservableStorage() {

    override fun loadByDateInterval(dto: T) =
        Single.create<U> { emitter ->

            val request = Request(
                data = loadByDateIntervalQueryFactory.create(dto),
                callback = onDataLoadedAction(emitter),
            )
            loader.load(request)
        }

    override fun loadById(dto: T) =
        Single.create<U> { emitter ->

            val request = Request(
                data = loadByIdQueryFactory.create(dto),
                callback = onDataLoadedAction(emitter),
            )
            loader.load(request)
        }
}