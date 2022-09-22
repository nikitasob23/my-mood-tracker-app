package com.niksob.app.viewmodel.auth.signup.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.niksob.app.viewmodel.auth.signup.useraddition.SignUpViewModelWithNewUserAdditionImpl
import com.niksob.data.provider.AppStringProvider
import com.niksob.domain.usecase.auth.SignUpWithEmailAndPasswordUseCase
import com.niksob.domain.usecase.auth.ValidateEmailUseCase
import com.niksob.domain.usecase.auth.ValidatePasswordUseCase
import com.niksob.domain.usecase.db.AddUserUseCase

class SignUpViewModelWithNewUserAdditionFactory(
    private val addUserUseCase: AddUserUseCase,
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val stringProvider: AppStringProvider,
    private val signUpWithEmailAndPasswordUseCase: SignUpWithEmailAndPasswordUseCase,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SignUpViewModelWithNewUserAdditionImpl(
            addUserUseCase = addUserUseCase,
            validateEmailUseCase = validateEmailUseCase,
            validatePasswordUseCase = validatePasswordUseCase,
            stringProvider = stringProvider,
            signUpWithEmailAndPasswordUseCase = signUpWithEmailAndPasswordUseCase,
        ) as T
    }
}