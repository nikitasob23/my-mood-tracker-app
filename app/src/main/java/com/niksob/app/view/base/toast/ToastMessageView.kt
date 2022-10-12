package com.niksob.app.view.base.toast

import com.niksob.app.toast.ToastMessage
import com.niksob.app.view.base.progressbar.ProgressbarView
import com.niksob.domain.model.Query
import javax.inject.Inject

abstract class ToastMessageView : ProgressbarView() {

    @Inject
    lateinit var toastMessage: ToastMessage

    abstract val successLoadMessage: String

    abstract val failedLoadMessage: String

    override fun onDataLoaded(response: Query?) {
        super.onDataLoaded(response)

        if (response == null) {
            return
        }

        if (response.completed) {
            showSuccessEntriesLoadToastMessage()
        } else {
            showFailedEntriesLoadMessage()
        }
    }

    protected open fun showSuccessEntriesLoadToastMessage() = toastMessage.showShortToast(successLoadMessage)

    protected open fun showFailedEntriesLoadMessage() = toastMessage.showShortToast(failedLoadMessage)
}