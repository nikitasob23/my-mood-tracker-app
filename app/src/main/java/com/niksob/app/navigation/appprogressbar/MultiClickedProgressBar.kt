package com.niksob.app.navigation.appprogressbar

import android.view.ViewGroup

//If first view invoke hiding progress, but another process had already invoked showing progress,
// then showing progress won t stop. It will stop, when all views invoke hiding progress.
class MultiClickedProgressBar(progressBarFrameLayout: ViewGroup) : MainProgressBar(progressBarFrameLayout) {

    private var clickedCounter = 0

    override fun showProgress() {
        clickedCounter++
        if (clickedCounter > 1) {
            return
        }
        super.showProgress()
    }

    override fun hideProgress() {
        clickedCounter--
        if (clickedCounter > 0) {
            return
        }
        super.hideProgress()
    }
}