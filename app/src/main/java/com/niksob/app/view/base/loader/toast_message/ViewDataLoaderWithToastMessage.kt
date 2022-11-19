package com.niksob.app.view.base.loader.toast_message

import com.niksob.app.toast.ToastMessage
import com.niksob.app.view.base.loader.base.ViewDataLoader
import io.reactivex.Single

class ViewDataLoaderWithToastMessage<T : Any>(
    private val loader: ViewDataLoader<T>,
    private val toastMessage: ToastMessage,
    private val successLoadMessage: String,
    private val cancelledLoadMessage: String,
) : ViewDataLoader<T>, ViewToastMessage<T> {

    override fun load(): Single<T> =
        loader.load()
            .doOnSuccess(this::showSuccessLoadingToastMessage)
            .doOnError(this::showCancelledLoadingToastMessage)

    override fun showSuccessLoadingToastMessage(t: T) = toastMessage.showShortToast(successLoadMessage)

    override fun showCancelledLoadingToastMessage(throwable: Throwable) =
        toastMessage.showShortToast(cancelledLoadMessage)
}