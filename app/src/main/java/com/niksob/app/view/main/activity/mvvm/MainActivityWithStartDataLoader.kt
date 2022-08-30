package com.niksob.app.view.main.activity.mvvm

import android.os.Bundle
import com.niksob.app.view.main.activity.toolbar.InjectableAppToolbar

open class MainActivityWithStartDataLoader : InjectableAppToolbar() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateViewDataLoading()
    }

    private fun onCreateViewDataLoading() = loadAuthorizeUserId()
}