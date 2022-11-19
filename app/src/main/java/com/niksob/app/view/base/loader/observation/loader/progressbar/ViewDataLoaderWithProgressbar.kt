package com.niksob.app.view.base.loader.observation.loader.progressbar

import com.niksob.app.view.base.loader.observation.loader.ViewDataLoader
import com.niksob.domain.navigation.appprogressbar.AppProgressBar

class ViewDataLoaderWithProgressbar<T : Any>(
    private val loader: ViewDataLoader<T>,
    private val progressbar: AppProgressBar,
) : ViewDataLoader<T> {

    override fun load() =
        loader.load()
            .doOnSubscribe { progressbar.showProgress() }
            .doAfterTerminate(progressbar::hideProgress)
}