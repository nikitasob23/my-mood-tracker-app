package com.niksob.app.progressbar.multiclicked

import android.view.ViewGroup
import com.niksob.app.progressbar.base.MainProgressBar

//If first view invoke hiding progress, but another process had already invoked showing progress,
// then showing progress won t stop. It will stop, when all views invoke hiding progress.
class MultiClickedProgressBar(progressBarFrameLayout: ViewGroup) : MainProgressBar(progressBarFrameLayout) {

    private var clickedCounter = 0

    override fun showProgress() {
        if (alreadyShow()) {
            return
        }
        clickedCounter++
        super.showProgress()
    }

    override fun hideProgress() {
        if (alreadyHide()) {
            return
        }
        clickedCounter--
        super.hideProgress()
    }

    private fun alreadyShow() = clickedCounter % 2 != 0

    private fun alreadyHide() = clickedCounter % 2 == 0
}