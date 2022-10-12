package com.niksob.app.view.base.loader

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.niksob.domain.model.Query

abstract class StartDataLoaderView : StartDataLoader, DataLoaderView() {

    lateinit var response: Query

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        onCreateViewDataLoading(response)
        return rootView
    }

    override fun onCreateViewDataLoading(response: Query?) = loadData(response)
}