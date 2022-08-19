package com.niksob.app.navigation.appprogressbar

import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import com.niksob.app.R

class MainProgressBar(
    private val progressBarFrameLayout: ViewGroup,
) : AppProgressBar {

    init {
        hideProgress()
        val background = progressBarFrameLayout.findViewById<FrameLayout>(R.id.main_progress_bar_layout__background)
        progressBarFrameLayout.bringChildToFront(background)
    }

    override fun showProgress() {
        progressBarFrameLayout.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBarFrameLayout.visibility = View.GONE
    }
}