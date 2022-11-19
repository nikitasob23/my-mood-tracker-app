package com.niksob.app.view.base.loader.observation.logger

interface ViewLogger<T> {

    fun logStartLoadMessage()

    fun logSuccessLoadMessage(t: T)

    fun logCancelledLoadMessage(throwable: Throwable)
}