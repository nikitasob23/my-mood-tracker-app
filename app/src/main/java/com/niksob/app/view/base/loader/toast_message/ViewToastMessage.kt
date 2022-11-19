package com.niksob.app.view.base.loader.toast_message

interface ViewToastMessage<T> {

    fun showSuccessLoadingToastMessage(t: T)

    fun showCancelledLoadingToastMessage(throwable: Throwable)
}