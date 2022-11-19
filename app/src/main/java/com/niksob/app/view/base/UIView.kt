package com.niksob.app.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.niksob.app.model.LayoutId
import com.niksob.app.navigation.model.NavigationableFragment

abstract class UIView : NavigationableFragment() {

    protected lateinit var rootView: View

    protected lateinit var layoutId: LayoutId

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        rootView = inflater.inflate(layoutId.id, container, false)
        return rootView
    }
}