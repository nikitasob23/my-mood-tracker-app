package com.niksob.app.view.moodentrieslist.logger

import com.niksob.app.view.moodentrieslist.toast.InjectableMoodEntriesListViewWithEntriesLoaderWithToastMessage
import com.niksob.domain.model.Query
import com.niksob.domain.utils.logger.AppDebugLogger
import javax.inject.Inject

private const val START_LOADING_MOOD_ENTRIES_MESSAGE = "Loading of mood entries has started"
private const val SUCCESSFUL_LOADING_MOOD_ENTRIES_MESSAGE = "Loading mood entries is succeed"
private const val FAILURE_LOADING_MOOD_ENTRIES_MESSAGE = "Loading mood entries is failed"

open class LoggableMoodEntriesListViewWithEntriesLoader : InjectableMoodEntriesListViewWithEntriesLoaderWithToastMessage() {

    @Inject
    lateinit var logger: AppDebugLogger

    private val logTag get() = LoggableMoodEntriesListViewWithEntriesLoader::class.simpleName!!

    override fun loadMoodEntriesByUserId() {
        logger.log(logTag, START_LOADING_MOOD_ENTRIES_MESSAGE)
        super.loadMoodEntriesByUserId()
    }

    override fun onLoadMoodEntriesCompleted(response: Query) {
        super.onLoadMoodEntriesCompleted(response)

        if (!response.completed) {
            logger.log(logTag, FAILURE_LOADING_MOOD_ENTRIES_MESSAGE)
            return
        }
        logger.log(logTag, SUCCESSFUL_LOADING_MOOD_ENTRIES_MESSAGE)
    }
}