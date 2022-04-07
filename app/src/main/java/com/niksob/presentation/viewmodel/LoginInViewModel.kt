package com.niksob.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.niksob.data.StringProvider
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query
import com.niksob.domain.model.LoginData
import com.niksob.domain.usecase.login.LoginInWithEmailAndPasswordUseCase
import com.niksob.domain.usecase.login.ValidateEmailUseCase
import com.niksob.domain.usecase.login.ValidatePasswordUseCase


private const val FAILED_REASON = "registration_failed"

class LoginInViewModel(
    private val loginInWithEmailAndPasswordUseCase: LoginInWithEmailAndPasswordUseCase,
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val stringProvider: StringProvider,
) : ViewModel() {

    private val queryLive = MutableLiveData<Query>()

    val query: LiveData<Query> = queryLive

    fun doLoginIn(loginData: LoginData) {
        if (validateEmailUseCase.execute(loginData.email) && validatePasswordUseCase.execute(loginData.password)) {

            queryLive.value = Query(
                data = loginData,
                completed = false,
                reason = stringProvider.getString(FAILED_REASON)
            )
            return
        }

        val query = Query(
            data = loginData,
            callback = Callback { query ->
                queryLive.value = query
            }
        )

        loginInWithEmailAndPasswordUseCase.execute(query)
    }
}