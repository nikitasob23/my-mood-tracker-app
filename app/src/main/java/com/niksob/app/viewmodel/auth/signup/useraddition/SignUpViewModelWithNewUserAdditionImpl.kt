package com.niksob.app.viewmodel.auth.signup.useraddition

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.niksob.app.viewmodel.auth.signup.base.SignUpViewModelWithNewUserAddition
import com.niksob.app.viewmodel.auth.signup.validation.SignUpViewModelWithLoginDataValidation
import com.niksob.data.provider.AppStringProvider
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query
import com.niksob.domain.model.Uid
import com.niksob.domain.model.User
import com.niksob.domain.usecase.auth.SignUpWithEmailAndPasswordUseCase
import com.niksob.domain.usecase.auth.ValidateEmailUseCase
import com.niksob.domain.usecase.auth.ValidatePasswordUseCase
import com.niksob.domain.usecase.db.AddUserUseCase

open class SignUpViewModelWithNewUserAdditionImpl(
    private val addUserUseCase: AddUserUseCase,
    validateEmailUseCase: ValidateEmailUseCase,
    validatePasswordUseCase: ValidatePasswordUseCase,
    stringProvider: AppStringProvider,
    signUpWithEmailAndPasswordUseCase: SignUpWithEmailAndPasswordUseCase,
) : SignUpViewModelWithNewUserAddition,
    SignUpViewModelWithLoginDataValidation(
        validateEmailUseCase,
        validatePasswordUseCase,
        stringProvider,
        signUpWithEmailAndPasswordUseCase,
    ) {
    override val userAdditionResponse: LiveData<Query>
        get() = mutableUserAdditionResponse

    protected val mutableUserAdditionResponse = MutableLiveData<Query>()

    override fun onSignUpCompleted(response: Query) {
        super.onSignUpCompleted(response)

        val user = User(
            id = response.data as Uid,
            email = email,
        )
        addUser(user)
    }

    override fun addUser(user: User) {
        val response = toUserAdditionResponse(user)
        addUserUseCase.execute(response)
    }

    protected open fun onUserAdditionCompleted(response: Query) {
        mutableUserAdditionResponse.value = response
    }

    private fun toUserAdditionResponse(user: User) =
        Query(
            data = user,
            callback = Callback { response -> onUserAdditionCompleted(response) }
        )
}