package com.niksob.app.model

import io.reactivex.observers.DisposableSingleObserver
import java.lang.IllegalStateException

class AutoDisposableSingleObserver<T : Any>(
    private val onSuccess: (T) -> Unit,
    private val onError: ((Throwable) -> Unit)? = null,
) : DisposableSingleObserver<T>() {

    override fun onSuccess(t: T) {
        onSuccess.invoke(t)
        dispose()
    }

    override fun onError(e: Throwable) {
        if (onError == null) {
            throw IllegalStateException()
        }
        onError.invoke(e)
        dispose()
    }
}