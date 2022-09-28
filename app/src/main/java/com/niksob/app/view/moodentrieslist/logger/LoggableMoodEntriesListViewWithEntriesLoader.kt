package com.niksob.app.view.moodentrieslist.logger

import com.niksob.app.R
import com.niksob.app.view.moodentrieslist.toast.InjectableMoodEntriesListViewWithEntriesLoaderWithToastMessage
import com.niksob.domain.model.Query
import com.niksob.domain.utils.logger.AppDebugLogger
import javax.inject.Inject

open class LoggableMoodEntriesListViewWithEntriesLoader :
    InjectableMoodEntriesListViewWithEntriesLoaderWithToastMessage() {

    @Inject
    lateinit var logger: AppDebugLogger

    private val logTag get() = LoggableMoodEntriesListViewWithEntriesLoader::class.simpleName!!

    private val startLoadingMoodEntriesMessage get() = requireContext().getString(R.string.start_loading_mood_entries)

    private val successfulLoadingMoodEntriesMessage
        get() = requireContext().getString(R.string.successful_loading_mood_entries)

    private val failureLoadingMoodEntriesMessage get() = requireContext().getString(R.string.failure_loading_mood_entries)

    override fun loadMoodEntriesByUserId() {
        logger.log(logTag, startLoadingMoodEntriesMessage)
        super.loadMoodEntriesByUserId()
    }

    override fun onLoadMoodEntriesCompleted(response: Query) {
        super.onLoadMoodEntriesCompleted(response)

        if (!response.completed) {
            logger.log(logTag, failureLoadingMoodEntriesMessage)
            return
        }
        logger.log(logTag, successfulLoadingMoodEntriesMessage)
    }
}