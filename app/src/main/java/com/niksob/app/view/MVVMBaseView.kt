package com.niksob.app.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.niksob.app.viewmodel.BaseViewModel
import javax.inject.Inject

abstract class MVVMBaseView : BaseView() {

    @Inject @JvmField
    var viewModel: BaseViewModel? = null

    protected abstract val onCreateViewDataLoading: (() -> Unit)?

    private val dataIsLoadingObserver = Observer<Boolean> { isLoading ->
        if (isLoading) {
            progressBar?.showProgress()
            return@Observer
        }
        progressBar?.hideProgress()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)

        inject()

        initComponents()

        viewModel?.dataIsLoading?.observe(viewLifecycleOwner, dataIsLoadingObserver)

        onCreateViewDataLoading?.invoke()

        return rootView
    }

    protected abstract fun inject()

    protected abstract fun initComponents()
}