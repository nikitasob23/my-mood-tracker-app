package com.niksob.app.viewmodel.auth.signup.base.signup

import androidx.lifecycle.LiveData
import com.niksob.domain.model.LoginData
import com.niksob.domain.model.Query

interface SignUpViewModel {

    val authResponse: LiveData<Query>

    fun doSignUp(loginData: LoginData)
}