package com.niksob.app.view.base.loader

import com.niksob.domain.model.Query

interface StartDataLoader {
    fun onCreateViewDataLoading(response: Query? = null)
}