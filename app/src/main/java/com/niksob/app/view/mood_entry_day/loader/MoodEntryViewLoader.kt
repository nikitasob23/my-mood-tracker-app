package com.niksob.app.view.mood_entry_day.loader

import com.niksob.app.view.base.loader.observation.logger.ViewLogger
import com.niksob.app.view.base.loader.observation.toast_message.ViewToastMessage
import com.niksob.app.viewmodel.mood_entry.base.observation.MoodEntryDayViewModel
import com.niksob.domain.model.MoodEntries
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

open class MoodEntryViewLoader(
    private val viewModel: MoodEntryDayViewModel,
    private val progressbar: AppProgressBar,
    private val logger: ViewLogger<MoodEntries>,
    private val toastMessage: ViewToastMessage<MoodEntries>,
) {

    fun loadByDateInterval() =
        viewModel.loadByDateInterval()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe(this::showProgress)
            .doOnSubscribe(this::logStartLoadMessage)
            .doAfterSuccess(this::logSuccessLoadMessage)
            .doAfterSuccess(this::showSuccessLoadingToastMessage)
            .doOnError(this::logCancelledLoadMessage)
            .doOnError(this::showCancelledLoadingToastMessage)
            .doAfterTerminate(this::hideProgress)

    private fun showProgress(disposable: Disposable) {
        progressbar.showProgress()
    }

    private fun hideProgress() {
        progressbar.hideProgress()
    }

    private fun logStartLoadMessage(disposable: Disposable) {
        logger.logStartLoadMessage()
    }

    private fun logSuccessLoadMessage(moodEntries: MoodEntries) {
        logger.logSuccessLoadMessage(moodEntries)
    }

    private fun logCancelledLoadMessage(t: Throwable) {
        logger.logCancelledLoadMessage(t)
    }

    private fun showSuccessLoadingToastMessage(moodEntries: MoodEntries) {
        toastMessage.showSuccessLoadingToastMessage(moodEntries)
    }

    private fun showCancelledLoadingToastMessage(t: Throwable) {
        toastMessage.showCancelledLoadingToastMessage(t)
    }
}
