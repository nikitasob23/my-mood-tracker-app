package com.niksob.app.view.base.logger

import com.niksob.app.R
import com.niksob.app.view.base.toast.ToastMessageView
import com.niksob.app.view.moodentrieslist.logger.LoggableMoodEntriesListViewWithEntriesLoader
import com.niksob.domain.model.Query
import com.niksob.domain.utils.logger.AppDebugLogger
import javax.inject.Inject

abstract class LoggableView : ToastMessageView() {

    @Inject
    lateinit var logger: AppDebugLogger

    private val logTag get() = LoggableMoodEntriesListViewWithEntriesLoader::class.simpleName!!

    private var startedMessage = requireContext().getString(R.string.started_load_mood_entries)

    private var succeedMessage = requireContext().getString(R.string.succeed_load_mood_entries)

    private var failureMessage = requireContext().getString(R.string.failure_load_mood_entries)

    override fun loadData(request: Query?) {
        logger.log(logTag, startedMessage)
        super.loadData(request)
    }

    override fun onDataLoaded(response: Query?) {
        super.onDataLoaded(response)

        if (response == null) {
            return
        }

        if (!response.completed) {
            logger.log(logTag, failureMessage)
            return
        }
        logger.log(logTag, succeedMessage)
    }
}