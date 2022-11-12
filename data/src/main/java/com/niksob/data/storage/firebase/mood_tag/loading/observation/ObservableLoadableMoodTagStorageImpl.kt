package com.niksob.data.storage.firebase.mood_tag.loading.observation

import com.niksob.data.model.Request
import com.niksob.data.storage.firebase.base.loader.FirebaseStorageLoader
import com.niksob.data.storage.firebase.base.loader.database_query_factory.FirebaseQueryFactory
import com.niksob.data.storage.firebase.base.loader.observation.BaseObservableStorage
import io.reactivex.Single

open class ObservableLoadableMoodTagStorageImpl<T : Any, U : Any>(
    private val loader: FirebaseStorageLoader<U>,
    private val loadByEntryIdQueryFactory: FirebaseQueryFactory,
) : ObservableLoadableMoodTagStorage<T, U>, BaseObservableStorage() {

    override fun loadByEntryId(dto: T) =
        Single.create<U> { emitter ->

            val request = Request(
                data = loadByEntryIdQueryFactory.create(dto),
                callback = onDataLoadedAction(emitter),
            )
            loader.load(request)
        }
}