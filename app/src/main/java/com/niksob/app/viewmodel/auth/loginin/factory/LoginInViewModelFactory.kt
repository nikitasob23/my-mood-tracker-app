package com.niksob.app.viewmodel.auth.loginin.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.niksob.app.viewmodel.auth.loginin.validation.LoginInViewModelWithValidation
import com.niksob.data.provider.AppStringProvider
import com.niksob.domain.usecase.auth.login_in.LoginInWithEmailAndPasswordUseCase
import com.niksob.domain.usecase.auth.validation.ValidateEmailUseCase
import com.niksob.domain.usecase.auth.validation.ValidatePasswordUseCase

class LoginInViewModelFactory(
    private val loginInUseCase: LoginInWithEmailAndPasswordUseCase,
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val stringProvider: AppStringProvider,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        LoginInViewModelWithValidation(
            validateEmailUseCase = validateEmailUseCase,
            validatePasswordUseCase = validatePasswordUseCase,
            stringProvider = stringProvider,
            loginInWithEmailAndPasswordUseCase = loginInUseCase,
        ) as T
}