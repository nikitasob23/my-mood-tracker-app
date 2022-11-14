package com.niksob.app.viewmodel.auth.signup.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.niksob.domain.model.Callback
import com.niksob.domain.model.LoginData
import com.niksob.domain.model.Query
import com.niksob.domain.usecase.auth.sign_up.SignUpWithEmailAndPasswordUseCase

open class BaseSignUpViewModel(
    private val signUpWithEmailAndPasswordUseCase: SignUpWithEmailAndPasswordUseCase,
) : SignUpViewModel, ViewModel() {

    override val authResponse: LiveData<Query>
        get() = mutableAuthResponse

    protected val mutableAuthResponse = MutableLiveData<Query>()

    protected lateinit var email: String

    override fun doSignUp(loginData: LoginData) {
        email = loginData.email

        val response = toAuthResponse(loginData)
        signUpWithEmailAndPasswordUseCase.execute(response)
    }

    protected open fun onSignUpCompleted(response: Query) {
        mutableAuthResponse.value = response
    }

    private fun toAuthResponse(loginData: LoginData) =
        Query(
            data = loginData,
            callback = Callback { response -> onSignUpCompleted(response) }
        )
}