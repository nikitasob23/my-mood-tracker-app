package com.niksob.app.viewmodel.auth.loginin.deprecated

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.niksob.app.viewmodel.auth.loginin.base.LoginInViewModel
import com.niksob.data.provider.AppStringProvider
import com.niksob.domain.model.Callback
import com.niksob.domain.model.LoginData
import com.niksob.domain.model.Query
import com.niksob.domain.usecase.auth.LoginInWithEmailAndPasswordUseCase
import com.niksob.domain.usecase.auth.ValidateEmailUseCase
import com.niksob.domain.usecase.auth.ValidatePasswordUseCase

private const val FAILED_REASON = "registration_failed"

class LoginInViewModelImpl(
    private val loginInWithEmailAndPasswordUseCase: LoginInWithEmailAndPasswordUseCase,
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val stringProvider: AppStringProvider,
) : LoginInViewModel, ViewModel() {

    private val _query = MutableLiveData<Query>()

    override val response: LiveData<Query> = _query

    override fun doLoginIn(loginData: LoginData) {
        if (validateEmailUseCase.execute(loginData.email) && validatePasswordUseCase.execute(
                loginData.password
            )
        ) {

            _query.value = Query(
                data = loginData,
                completed = false,
                reason = stringProvider.getString(FAILED_REASON)
            )
            return
        }

        val query = Query(
            data = loginData,
            callback = Callback { query ->
                _query.value = query
            }
        )

        loginInWithEmailAndPasswordUseCase.execute(query)
    }
}