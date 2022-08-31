package com.niksob.app.view.main.activity.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.niksob.app.navigation.NavigationableFragment

abstract class BaseView : NavigationableFragment() {

    protected lateinit var rootView: View

    protected abstract val layout: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        rootView = inflater.inflate(layout, container, false)
        return rootView
    }
}