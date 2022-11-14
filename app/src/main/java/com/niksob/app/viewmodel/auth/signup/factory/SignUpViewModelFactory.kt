package com.niksob.app.viewmodel.auth.signup.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.niksob.app.viewmodel.auth.signup.validation.SignUpViewModelWithLoginDataValidation
import com.niksob.data.provider.AppStringProvider
import com.niksob.domain.usecase.auth.sign_up.SignUpWithEmailAndPasswordUseCase
import com.niksob.domain.usecase.auth.validation.ValidateEmailUseCase
import com.niksob.domain.usecase.auth.validation.ValidatePasswordUseCase

class SignUpViewModelFactory(
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val stringProvider: AppStringProvider,
    private val signUpWithEmailAndPasswordUseCase: SignUpWithEmailAndPasswordUseCase,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SignUpViewModelWithLoginDataValidation(
            validateEmailUseCase = validateEmailUseCase,
            validatePasswordUseCase = validatePasswordUseCase,
            stringProvider = stringProvider,
            signUpWithEmailAndPasswordUseCase = signUpWithEmailAndPasswordUseCase,
        ) as T
    }
}