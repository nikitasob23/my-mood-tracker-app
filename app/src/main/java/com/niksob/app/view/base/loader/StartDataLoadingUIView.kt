package com.niksob.app.view.base.loader

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.niksob.app.view.base.injection.InjectableUIView

abstract class StartDataLoadingUIView : StartDataLoader, InjectableUIView() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        onCreateViewDataLoading()
        return rootView
    }

    override fun onCreateViewDataLoading() = Unit
}