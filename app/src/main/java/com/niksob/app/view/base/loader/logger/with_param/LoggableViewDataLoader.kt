package com.niksob.app.view.base.loader.logger.with_param

import com.niksob.app.view.base.loader.base.with_parameter.ViewDataLoader
import com.niksob.app.view.base.loader.logger.ViewLogger
import com.niksob.domain.utils.logger.AppDebugLogger

class LoggableViewDataLoader<T : Any, U : Any>(
    private val loader: ViewDataLoader<T, U>,
    private val logger: AppDebugLogger,
    private val startLoadMessage: String,
    private val successLoadMessage: String,
    private val cancelledLoadMessage: String,
) : ViewDataLoader<T, U>, ViewLogger<U> {

    override fun load(data: T?) =
        loader.load()
            .doOnSubscribe { logStartLoadMessage() }
            .doOnSuccess(this::logSuccessLoadMessage)
            .doOnError(this::logCancelledLoadMessage)

    private val logTag get() = this::class.simpleName!!

    override fun logStartLoadMessage() {
        logger.log(logTag, startLoadMessage)
    }

    override fun logSuccessLoadMessage(t: U) {
        logger.log(logTag, successLoadMessage)
    }

    override fun logCancelledLoadMessage(throwable: Throwable) {
        logger.log(logTag, cancelledLoadMessage)
    }
}