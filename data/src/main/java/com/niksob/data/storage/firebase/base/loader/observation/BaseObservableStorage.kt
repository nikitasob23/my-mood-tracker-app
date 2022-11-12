package com.niksob.data.storage.firebase.base.loader.observation

import com.niksob.data.model.OnDataCompletedAction
import com.niksob.data.model.OnDataLoadedAction
import io.reactivex.CompletableEmitter
import io.reactivex.SingleEmitter

open class BaseObservableStorage {

    protected open fun <T : Any> onDataLoadedAction(emitter: SingleEmitter<T>) =
        object : OnDataLoadedAction<T> {

            override fun onDataLoaded(resultData: T) = emitter.onSuccess(resultData)

            override fun onDataCancelled(e: Throwable) = emitter.onError(e)
        }

    protected open fun onDataCompletedAction(emitter: CompletableEmitter) =
        object : OnDataCompletedAction {

            override fun onDataCompleted() = emitter.onComplete()

            override fun onDataCancelled(e: Throwable) = emitter.onError(e)
        }
}