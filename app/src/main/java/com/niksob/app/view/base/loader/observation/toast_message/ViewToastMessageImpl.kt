package com.niksob.app.view.base.loader.observation.toast_message

import com.niksob.app.toast.ToastMessage

class ViewToastMessageImpl<T>(
    private val toastMessage: ToastMessage,
    private val successLoadMessage: String,
    private val cancelledLoadMessage: String,
) : ViewToastMessage<T> {

    override fun showSuccessLoadingToastMessage(t: T) = toastMessage.showShortToast(successLoadMessage)

    override fun showCancelledLoadingToastMessage(throwable: Throwable) =
        toastMessage.showShortToast(cancelledLoadMessage)
}