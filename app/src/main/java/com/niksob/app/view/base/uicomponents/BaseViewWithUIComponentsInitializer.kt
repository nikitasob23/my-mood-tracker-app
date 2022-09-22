package com.niksob.app.view.base.uicomponents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.niksob.app.view.base.BaseView

abstract class BaseViewWithUIComponentsInitializer : ViewComponentsInitializer, BaseView() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        rootView = super.onCreateView(inflater, container, savedInstanceState)
        initComponents()
        return rootView
    }

    override fun initComponents() = Unit
}
