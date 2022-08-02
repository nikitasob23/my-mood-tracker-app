package com.niksob.app.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.niksob.app.viewmodel.DataLoadingStatus
import com.niksob.app.viewmodel.DataLoadingStatus.*
import com.niksob.app.viewmodel.ViewModelWithLoadingStatus
import javax.inject.Inject

abstract class MVVMBaseView : BaseView() {

    @Inject
    @JvmField
    var viewModel: ViewModelWithLoadingStatus? = null

    private var dataIsLoadingObserver = Observer<DataLoadingStatus> { loadingStatus ->

        if (loadingStatus == LOADING) {
            progressBar?.showProgress()
        } else if (loadingStatus == LOADING_COMPLETED) {
            progressBar?.hideProgress()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)

        inject()

        initComponents()

        viewModel?.dataLoadingStatus?.observe(viewLifecycleOwner, dataIsLoadingObserver)

        onCreateViewDataLoading()

        return rootView
    }

    protected open fun onCreateViewDataLoading() = Unit

    protected open fun inject() = Unit

    protected open fun initComponents() = Unit
}