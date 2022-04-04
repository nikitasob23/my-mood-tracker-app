package com.niksob.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.niksob.domain.model.login.AuthCallback
import com.niksob.domain.model.login.AuthResponse
import com.niksob.domain.usecase.login.LoadAuthorizeUserIdUseCase

class LoginViewModel(
    private val loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
) : ViewModel() {

    private val responseLive = MutableLiveData<AuthResponse>()

    val response: LiveData<AuthResponse> = responseLive

    fun loadAuthorizeUserId() {

        val callback = AuthCallback { response ->
            responseLive.value = response
        }
        loadAuthorizeUserIdUseCase.execute(callback)
    }
}