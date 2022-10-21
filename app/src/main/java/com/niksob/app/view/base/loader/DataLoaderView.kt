package com.niksob.app.view.base.loader

import com.niksob.app.view.base.navigation.NavigationableView
import com.niksob.domain.model.Query
import javax.inject.Inject
import javax.inject.Named

abstract class DataLoaderView : NavigationableView() {

    @Inject
    @Named("success_load_message")
    lateinit var successLoadMessage: String

    @Inject
    @Named("failure_load_message")
    lateinit var failedLoadMessage: String

    protected open fun loadData(request: Query? = null, loadDataCallback: () -> Unit) = loadDataCallback()

    protected open fun onDataLoaded(response: Query? = null, onDataLoadedCallback: () -> Unit) = onDataLoadedCallback()
}