package com.niksob.app.view.base.logger

import com.niksob.app.view.base.toast.ToastMessageView
import com.niksob.domain.model.Query
import com.niksob.domain.utils.logger.AppDebugLogger
import javax.inject.Inject
import javax.inject.Named

abstract class LoggableView : ToastMessageView() {

    @Inject
    lateinit var logger: AppDebugLogger

    @Inject
    @Named("start_load_message")
    lateinit var startLoadMessage: String

    private val logTag get() = this::class.simpleName!!

    override fun loadData(request: Query?, loadDataCallback: () -> Unit) {
        logger.log(logTag, startLoadMessage)
        super.loadData(request, loadDataCallback)
    }

    override fun onDataLoaded(response: Query?, onDataLoadedCallback: () -> Unit) {
        super.onDataLoaded(response, onDataLoadedCallback)

        if (response == null) {
            return
        }

        if (!response.completed) {
            logger.log(logTag, failedLoadMessage)
            return
        }
        logger.log(logTag, successLoadMessage)
    }
}