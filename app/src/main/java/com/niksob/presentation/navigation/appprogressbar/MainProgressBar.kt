package com.niksob.presentation.navigation.appprogressbar

import android.view.View
import android.widget.FrameLayout
import android.widget.ProgressBar
import com.niksob.domain.navigation.appprogressbar.AppProgressBar

class MainProgressBar(
    private val progressBar: ProgressBar,
    private val mainScreen: FrameLayout,
) : AppProgressBar {

    init {
        hideProgress()
    }

    override fun showProgress() {
        mainScreen.alpha = 0.2f
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        mainScreen.alpha = 1f
        progressBar.visibility = View.GONE
    }
}