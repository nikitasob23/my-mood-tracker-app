package com.niksob.app.view.mood_entry_addition.progressbar

import com.niksob.app.view.mood_entry_addition.ui_component.RecycleMoodTagsComponentView
import com.niksob.domain.model.Query
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import javax.inject.Inject

open class ProgressbarMoodEntryAdditionView : RecycleMoodTagsComponentView() {

    @Inject
    lateinit var progressbar: AppProgressBar

    override fun loadMoodEntryByUserId() {
        showProgress()
        super.loadMoodEntryByUserId()
    }

    override fun onLoadMoodEntryCompleted(response: Query) {
        super.onLoadMoodEntryCompleted(response)
        hideProgress()
    }

    protected open fun showProgress() = progressbar.showProgress()

    protected open fun hideProgress() = progressbar.hideProgress()
}