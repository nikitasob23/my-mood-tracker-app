package com.niksob.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.niksob.data.StringProvider
import com.niksob.domain.model.AuthResponse
import com.niksob.domain.model.LoginData
import com.niksob.domain.model.LoginDataCallback
import com.niksob.domain.usecase.login.LoginInWithEmailAndPasswordUseCase
import com.niksob.domain.usecase.login.ValidateEmailUseCase
import com.niksob.domain.usecase.login.ValidatePasswordUseCase


private const val FAILED_REASON = "authorize_failed"

class LoginInViewModel(
    private val loginInWithEmailAndPasswordUseCase: LoginInWithEmailAndPasswordUseCase,
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val stringProvider: StringProvider,
) : ViewModel() {

    private val responseLive = MutableLiveData<AuthResponse>()

    val response: LiveData<AuthResponse> = responseLive

    fun doLoginIn(loginData: LoginData) {
        if (validateEmailUseCase.execute(loginData.email) && validatePasswordUseCase.execute(loginData.password)) {
            responseLive.value = AuthResponse(
                success = false,
                reason = stringProvider.getString(FAILED_REASON)
            )
            return
        }

        val loginDataCallBack = LoginDataCallback(loginData) { response ->
            responseLive.value = response
        }
        loginInWithEmailAndPasswordUseCase.execute(loginDataCallBack)
    }
}