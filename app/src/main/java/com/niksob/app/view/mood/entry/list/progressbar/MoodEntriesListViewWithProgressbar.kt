package com.niksob.app.view.mood.entry.list.progressbar

import com.niksob.app.view.mood.entry.list.mvvm.startdataloader.InjectedMoodEntriesListViewWithStartDataLoader
import com.niksob.domain.model.Query
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import javax.inject.Inject

open class MoodEntriesListViewWithProgressbar : InjectedMoodEntriesListViewWithStartDataLoader() {

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