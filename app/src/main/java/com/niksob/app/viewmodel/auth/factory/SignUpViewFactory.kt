package com.niksob.app.viewmodel.auth.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.niksob.app.viewmodel.auth.SignUpViewModel
import com.niksob.data.provider.AppStringProvider
import com.niksob.domain.usecase.db.AddUserUseCase
import com.niksob.domain.usecase.auth.SignUpWithEmailAndPasswordUseCase
import com.niksob.domain.usecase.auth.ValidateEmailUseCase
import com.niksob.domain.usecase.auth.ValidatePasswordUseCase


@Suppress("UNCHECKED_CAST")
class SignUpViewModelFactory(
    private val loginUpUseCase: SignUpWithEmailAndPasswordUseCase,
    private val addUserUseCase: AddUserUseCase,
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val stringProvider: AppStringProvider,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SignUpViewModel(
            loginUpUseCase,
            addUserUseCase,
            validateEmailUseCase,
            validatePasswordUseCase,
            stringProvider,
        ) as T
    }
}