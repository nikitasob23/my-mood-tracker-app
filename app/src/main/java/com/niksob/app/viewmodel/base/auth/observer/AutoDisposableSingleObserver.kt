package com.niksob.app.viewmodel.base.auth.observer

import io.reactivex.observers.DisposableSingleObserver

open class AutoDisposableSingleObserver<T : Any>(
    private val onSuccessCallback: ((T) -> Unit)? = null,
    private val onErrorCallback: ((Throwable) -> Unit)? = null,
) : DisposableSingleObserver<T>() {

    override fun onSuccess(t: T) {
        onSuccessCallback?.invoke(t)
        dispose()
    }

    override fun onError(e: Throwable) {
        onErrorCallback?.invoke(e)
        dispose()
    }
}