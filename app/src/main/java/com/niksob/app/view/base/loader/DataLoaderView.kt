package com.niksob.app.view.base.loader

import com.niksob.app.model.BaseViewModels
import com.niksob.app.view.base.navigation.NavigationableView
import com.niksob.domain.model.Query

abstract class DataLoaderView : NavigationableView() {
    
    lateinit var viewModels: BaseViewModels
    
    abstract var loadDataCallback: (Query?) -> Unit

    abstract var onDataLoadedCallback: (Query?) -> Unit

    protected open fun loadData(request: Query? = null) = loadDataCallback(request)

    protected open fun onDataLoaded(response: Query? = null) = onDataLoadedCallback(response)
}