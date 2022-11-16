package com.niksob.app.view.mood_entry_day.common.logger

import com.niksob.domain.utils.logger.AppDebugLogger

class ViewLoggerImpl(
    private val logger: AppDebugLogger,
    private val startLoadMessage: String,
    private val successLoadMessage: String,
    private val cancelledLoadMessage: String,
) : ViewLogger {

    private val logTag get() = this::class.simpleName!!

    override fun logStartLoadMessage() {
        logger.log(logTag, startLoadMessage)
    }

    override fun logSuccessLoadMessage() {
        logger.log(logTag, successLoadMessage)
    }

    override fun logCancelledLoadMessage() {
        logger.log(logTag, cancelledLoadMessage)
    }
}