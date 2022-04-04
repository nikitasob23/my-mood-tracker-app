package com.niksob.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.niksob.data.StringProvider
import com.niksob.domain.model.Callback
import com.niksob.domain.model.db.User
import com.niksob.domain.model.db.UserCallback
import com.niksob.domain.model.db.UserAdditionResponse
import com.niksob.domain.model.login.AuthCallback
import com.niksob.domain.model.login.AuthResponse
import com.niksob.domain.model.login.LoginData
import com.niksob.domain.model.login.LoginDataCallback
import com.niksob.domain.usecase.db.AddUserUseCase
import com.niksob.domain.usecase.login.SignUpWithEmailAndPasswordUseCase
import com.niksob.domain.usecase.login.ValidateEmailUseCase
import com.niksob.domain.usecase.login.ValidatePasswordUseCase

private const val FAILED_REASON = "registration_failed"

class SignUpViewModel(
    private val loginUpWithEmailAndPasswordUseCase: SignUpWithEmailAndPasswordUseCase,
    private val addUserUseCase: AddUserUseCase,
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val stringProvider: StringProvider,
) : ViewModel() {

    private val authResponseLive = MutableLiveData<AuthResponse>()

    private val userAdditionResponseLive = MutableLiveData<UserAdditionResponse>()

    val authResponse: LiveData<AuthResponse> = authResponseLive

    val userAdditionResponse: LiveData<UserAdditionResponse> = userAdditionResponseLive

    fun doLoginUp(loginData: LoginData) {
        if (validateEmailUseCase.execute(loginData.email) && validatePasswordUseCase.execute(loginData.password)) {
            authResponseLive.value = AuthResponse(
                success = false,
                reason = stringProvider.getString(FAILED_REASON)
            )
            return
        }

        val loginDataCallback = LoginDataCallback(loginData, AuthCallback { response ->
            authResponseLive.value = response
        })
        loginUpWithEmailAndPasswordUseCase.execute(loginDataCallback)
    }

    fun addUser(user: User) {
        val userCallback = UserCallback(
            user,
            Callback { response ->
                userAdditionResponseLive.value = response
            }
        )
        addUserUseCase.execute(userCallback)
    }
}