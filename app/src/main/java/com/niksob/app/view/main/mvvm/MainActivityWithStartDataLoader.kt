package com.niksob.app.view.main.mvvm

import android.os.Bundle
import com.niksob.app.view.main.toolbar.MainActivityWithToolbar

open class MainActivityWithStartDataLoader : MainActivityWithToolbar() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateViewDataLoading()
    }

    private fun onCreateViewDataLoading() = loadAuthorizeUserId()
}