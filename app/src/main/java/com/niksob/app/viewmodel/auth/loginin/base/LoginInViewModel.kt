package com.niksob.app.viewmodel.auth.loginin.base

import androidx.lifecycle.LiveData
import com.niksob.domain.model.Query
import com.niksob.domain.model.LoginData

interface LoginInViewModel {

    val response: LiveData<Query>

    fun doLoginIn(loginData: LoginData)
}