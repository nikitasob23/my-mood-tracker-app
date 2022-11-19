package com.niksob.app.view.base.loader.observation.logger

import com.niksob.domain.utils.logger.AppDebugLogger

class ViewLoggerImpl<T>(
    private val logger: AppDebugLogger,
    private val startLoadMessage: String,
    private val successLoadMessage: String,
    private val cancelledLoadMessage: String,
) : ViewLogger<T> {

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