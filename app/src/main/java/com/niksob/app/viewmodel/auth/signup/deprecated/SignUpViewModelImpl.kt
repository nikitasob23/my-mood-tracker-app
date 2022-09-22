package com.niksob.app.viewmodel.auth.signup.deprecated

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.niksob.app.viewmodel.auth.signup.base.useraddition.SignUpViewModelWithNewUserAddition
import com.niksob.data.provider.AppStringProvider
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query
import com.niksob.domain.model.User
import com.niksob.domain.model.LoginData
import com.niksob.domain.usecase.db.AddUserUseCase
import com.niksob.domain.usecase.auth.SignUpWithEmailAndPasswordUseCase
import com.niksob.domain.usecase.auth.ValidateEmailUseCase
import com.niksob.domain.usecase.auth.ValidatePasswordUseCase

private const val FAILED_REASON = "registration_failed"

class SignUpViewModelImpl(
    private val loginUpWithEmailAndPasswordUseCase: SignUpWithEmailAndPasswordUseCase,
    private val addUserUseCase: AddUserUseCase,
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val stringProvider: AppStringProvider,
) : SignUpViewModelWithNewUserAddition, ViewModel() {

    private val _authResponse = MutableLiveData<Query>()

    private val _userAdditionResponse = MutableLiveData<Query>()

    override val authResponse: LiveData<Query> = _authResponse

    override val userAdditionResponse: LiveData<Query> = _userAdditionResponse

    override fun doSignUp(loginData: LoginData) {
        if (validateEmailUseCase.execute(loginData.email) && validatePasswordUseCase.execute(loginData.password)) {
            _authResponse.value = Query(
                reason = stringProvider.getString(FAILED_REASON)
            )
            return
        }

        val query = Query(
            data = loginData,
            callback = Callback { query ->
                _authResponse.value = query
            }
        )
        loginUpWithEmailAndPasswordUseCase.execute(query)
    }

    override fun addUser(user: User) {
        val query = Query(
            data = user,
            callback = Callback { query ->
                _userAdditionResponse.value = query
            }
        )
        addUserUseCase.execute(query)
    }
}