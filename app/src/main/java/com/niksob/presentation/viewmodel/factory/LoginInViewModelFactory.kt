package com.niksob.presentation.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.niksob.domain.usecase.loginin.LoginInUseCase
import com.niksob.domain.usecase.loginin.ValidateEmailUseCase
import com.niksob.domain.usecase.loginin.ValidatePasswordUseCase
import com.niksob.presentation.viewmodel.LoginInViewModel

@Suppress("UNCHECKED_CAST")
class LoginInViewModelFactory(
    private val loginInUseCase: LoginInUseCase,
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginInViewModel(
            loginInUseCase,
            validateEmailUseCase,
            validatePasswordUseCase,
        ) as T
    }
}