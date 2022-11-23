package com.niksob.app.view.base.loader.progressbar.with_param

import com.niksob.app.view.base.loader.base.with_parameter.ViewDataLoader
import com.niksob.domain.navigation.appprogressbar.AppProgressBar

class ViewDataLoaderWithProgressbar<T : Any, U : Any>(
    private val loader: ViewDataLoader<T, U>,
    private val progressbar: AppProgressBar,
) : ViewDataLoader<T, U> {

    override fun load(data: T?) =
        loader.load()
            .doOnSubscribe { progressbar.showProgress() }
            .doAfterTerminate(progressbar::hideProgress)
}