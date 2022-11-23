package com.niksob.app.view.base.loader.toast_message.with_param

import com.niksob.app.toast.ToastMessage
import com.niksob.app.view.base.loader.base.with_parameter.ViewDataLoader
import com.niksob.app.view.base.loader.toast_message.ViewToastMessage
import io.reactivex.Single

class ViewDataLoaderWithToastMessage<T : Any, U : Any>(
    private val loader: ViewDataLoader<T, U>,
    private val toastMessage: ToastMessage,
    private val successLoadMessage: String,
    private val cancelledLoadMessage: String,
) : ViewDataLoader<T, U>, ViewToastMessage<U> {

    override fun load(data: T?): Single<U> =
        loader.load()
            .doOnSuccess(this::showSuccessLoadingToastMessage)
            .doOnError(this::showCancelledLoadingToastMessage)

    override fun showSuccessLoadingToastMessage(t: U) = toastMessage.showShortToast(successLoadMessage)

    override fun showCancelledLoadingToastMessage(throwable: Throwable) =
        toastMessage.showShortToast(cancelledLoadMessage)
}