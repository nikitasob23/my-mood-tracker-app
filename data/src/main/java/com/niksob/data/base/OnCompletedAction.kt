package com.niksob.data.base

import com.niksob.domain.model.Query

interface OnCompletedAction {

    fun onSucceed(request: Query)

    fun onFailure(request: Query, exceptionMessage: String? = null)
}
