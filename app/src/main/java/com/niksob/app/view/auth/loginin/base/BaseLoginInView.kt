package com.niksob.app.view.auth.loginin.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.niksob.app.R
import com.niksob.app.view.ViewComponentsInitializer
import com.niksob.app.view.main.activity.base.BaseView

open class BaseLoginInView : ViewComponentsInitializer, BaseView() {

    override val layout get() = R.layout.login_in_view

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        rootView = super.onCreateView(inflater, container, savedInstanceState)
        initComponents()
        return rootView
    }

    override fun initComponents() = Unit
}