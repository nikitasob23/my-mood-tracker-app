package com.niksob.app.view.base.loader.observation.loader.logger

import com.niksob.app.view.base.loader.observation.loader.ViewDataLoader
import com.niksob.app.view.base.loader.observation.logger.ViewLogger
import com.niksob.domain.utils.logger.AppDebugLogger

class LoggableViewDataLoader<T : Any>(
    private val loader: ViewDataLoader<T>,
    private val logger: AppDebugLogger,
    private val startLoadMessage: String,
    private val successLoadMessage: String,
    private val cancelledLoadMessage: String,
) : ViewDataLoader<T>, ViewLogger<T> {

    override fun load() =
        loader.load()
            .doOnSubscribe { logStartLoadMessage() }
            .doOnSuccess(this::logSuccessLoadMessage)
            .doOnError(this::logCancelledLoadMessage)

    private val logTag get() = this::class.simpleName!!

    override fun logStartLoadMessage() {
        logger.log(logTag, startLoadMessage)
    }

    override fun logSuccessLoadMessage(t: T) {
        logger.log(logTag, successLoadMessage)
    }

    override fun logCancelledLoadMessage(throwable: Throwable) {
        logger.log(logTag, cancelledLoadMessage)
    }
}