package com.niksob.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.niksob.domain.model.AuthResponse
import com.niksob.domain.usecase.loginin.ValidateEmailUseCase
import com.niksob.domain.usecase.loginin.ValidatePasswordUseCase
import com.niksob.domain.model.LoginData
import com.niksob.domain.usecase.loginin.LoginInUseCase

const val FAILED_REASON = "Failed"

class LoginInViewModel(
    private val loginInUseCase: LoginInUseCase,
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
) : ViewModel() {

    private val response = MutableLiveData<AuthResponse>()

    val responseLive: LiveData<AuthResponse> = response

    fun doLoginIn(loginData: LoginData) {
        if (validateEmailUseCase.execute(loginData.email) && validatePasswordUseCase.execute(loginData.password)) {
            response.value = AuthResponse(
                success = false,
                reason = FAILED_REASON
            )
        }
        response.value = loginInUseCase.execute(loginData)
    }
}