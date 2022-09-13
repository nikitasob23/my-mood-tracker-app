package com.niksob.app.viewmodel.auth.loginin

import androidx.lifecycle.LiveData
import com.niksob.domain.model.Query
import com.niksob.domain.model.LoginData

interface LoginInViewModel {

    val query: LiveData<Query>

    fun doLoginIn(loginData: LoginData)
}