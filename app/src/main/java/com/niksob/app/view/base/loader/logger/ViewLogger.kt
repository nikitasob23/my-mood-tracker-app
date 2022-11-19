package com.niksob.app.view.base.loader.logger

interface ViewLogger<T> {

    fun logStartLoadMessage()

    fun logSuccessLoadMessage(t: T)

    fun logCancelledLoadMessage(throwable: Throwable)
}