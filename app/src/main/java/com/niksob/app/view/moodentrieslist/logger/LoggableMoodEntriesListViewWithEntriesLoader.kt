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

    private lateinit var startedMessage: String
    private lateinit var succeedMessage: String
    private lateinit var failureMessage: String

    override fun initComponents() {
        super.initComponents()

        startedMessage = getString(R.string.started_load_mood_entries)
        succeedMessage = getString(R.string.succeed_load_mood_entries)
        failureMessage = getString(R.string.failure_load_mood_entries)
    }

    override fun loadMoodEntriesByUserId() {
        logger.log(logTag, startedMessage)
        super.loadMoodEntriesByUserId()
    }

    override fun onLoadMoodEntriesCompleted(response: Query) {
        super.onLoadMoodEntriesCompleted(response)

        if (!response.completed) {
            logger.log(logTag, failureMessage)
            return
        }
        logger.log(logTag, succeedMessage)
    }
}