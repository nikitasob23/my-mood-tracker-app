package com.niksob.app.viewmodel.main

import androidx.lifecycle.LiveData
import com.niksob.domain.model.Query

interface MainActivityViewModel {
    val loadAuthUserResponse: LiveData<Query>

    val signOutResponse: LiveData<Query>

    fun loadAuthorizeUserId()

    fun signOut()
}
