package com.niksob.app.view.moodentrieslist.progressbar

import com.niksob.app.view.moodentrieslist.viewmodel.startdataloader.InjectedMoodEntriesListViewWithEntriesLoaderWithStartDataLoader
import com.niksob.domain.model.Query
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import javax.inject.Inject

open class MoodEntriesListViewWithProgressbarWithEntriesLoader : InjectedMoodEntriesListViewWithEntriesLoaderWithStartDataLoader() {

    @Inject
    lateinit var progressbar: AppProgressBar

    override fun loadMoodEntriesByUserId() {
        showProgress()
        super.loadMoodEntriesByUserId()
    }

    override fun onLoadMoodEntriesCompleted(response: Query) {
        super.onLoadMoodEntriesCompleted(response)
        hideProgress()
    }

    protected open fun showProgress() = progressbar.showProgress()

    protected open fun hideProgress() = progressbar.hideProgress()
}