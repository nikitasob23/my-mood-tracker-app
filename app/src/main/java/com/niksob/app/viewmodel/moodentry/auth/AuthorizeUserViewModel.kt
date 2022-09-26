package com.niksob.app.viewmodel.moodentry.auth

import com.niksob.domain.model.Query

interface AuthorizeUserViewModel {

    fun loadAuthorizeUser(onLoadAuthorizeUserCompleted: (Query) -> Unit)
}