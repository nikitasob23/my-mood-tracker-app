package com.niksob.app.view.base.progressbar

import com.niksob.app.view.base.loader.StartDataLoaderView
import com.niksob.domain.model.Query
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import javax.inject.Inject

abstract class ProgressbarView : StartDataLoaderView() {

    @Inject
    lateinit var progressbar: AppProgressBar

    override fun loadData(request: Query?, loadDataCallback: () -> Unit) {
        showProgress()
        super.loadData(request, loadDataCallback)
    }

    override fun onDataLoaded(response: Query?, onDataLoadedCallback: () -> Unit) {
        super.onDataLoaded(response, onDataLoadedCallback)
        hideProgress()
    }

    protected open fun showProgress() = progressbar.showProgress()

    protected open fun hideProgress() = progressbar.hideProgress()
}