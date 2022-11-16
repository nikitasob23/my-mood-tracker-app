package com.niksob.app.view.mood_entry_day.common.toast_message

import com.niksob.app.toast.ToastMessage

class ViewToastMessageImpl(
    private val toastMessage: ToastMessage,
    private val successLoadMessage: String,
    private val cancelledLoadMessage: String,
) : ViewToastMessage {

    override fun showSuccessLoadingToastMessage() = toastMessage.showShortToast(successLoadMessage)

    override fun showCancelledLoadingToastMessage() = toastMessage.showShortToast(cancelledLoadMessage)
}