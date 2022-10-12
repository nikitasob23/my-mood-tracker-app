package com.niksob.app.view.base.progressbar

import com.niksob.app.view.base.loader.StartDataLoaderView
import com.niksob.domain.model.Query
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import javax.inject.Inject

abstract class ProgressbarView : StartDataLoaderView() {

    @Inject
    lateinit var progressbar: AppProgressBar

    override fun loadData(request: Query?) {
        showProgress()
        super.loadData(request)
    }

    override fun onDataLoaded(response: Query?) {
        super.onDataLoaded(response)
        hideProgress()
    }

    protected open fun showProgress() = progressbar.showProgress()

    protected open fun hideProgress() = progressbar.hideProgress()
}