package com.niksob.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.niksob.data.StringProvider
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query
import com.niksob.domain.model.User
import com.niksob.domain.model.LoginData
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

    private val authQueryLive = MutableLiveData<Query>()

    private val userAdditionQueryLive = MutableLiveData<Query>()

    val authQuery: LiveData<Query> = authQueryLive

    val userAdditionQuery: LiveData<Query> = userAdditionQueryLive

    fun doLoginUp(loginData: LoginData) {
        if (validateEmailUseCase.execute(loginData.email) && validatePasswordUseCase.execute(loginData.password)) {
            authQueryLive.value = Query(
                reason = stringProvider.getString(FAILED_REASON)
            )
            return
        }

        val query = Query(
            data = loginData,
            callback = Callback { query ->
                authQueryLive.value = query
            }
        )
        loginUpWithEmailAndPasswordUseCase.execute(query)
    }

    fun addUser(user: User) {
        val query = Query(
            data = user,
            callback = Callback { query ->
                userAdditionQueryLive.value = query
            }
        )
        addUserUseCase.execute(query)
    }
}