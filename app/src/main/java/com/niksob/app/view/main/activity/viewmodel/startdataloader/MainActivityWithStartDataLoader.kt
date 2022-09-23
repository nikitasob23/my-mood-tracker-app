package com.niksob.app.view.main.activity.viewmodel.startdataloader

import android.os.Bundle
import com.niksob.app.view.main.activity.toolbar.app.injection.InjectableAppToolbar

open class MainActivityWithStartDataLoader : InjectableAppToolbar() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateViewDataLoading()
    }

    private fun onCreateViewDataLoading() = loadAuthorizeUserId()
}