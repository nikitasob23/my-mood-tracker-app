package com.niksob.app.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.niksob.data.provider.AppStringProvider
import com.niksob.domain.usecase.auth.LoginInWithEmailAndPasswordUseCase
import com.niksob.domain.usecase.auth.ValidateEmailUseCase
import com.niksob.domain.usecase.auth.ValidatePasswordUseCase
import com.niksob.app.viewmodel.LoginInViewModel

@Suppress("UNCHECKED_CAST")
class LoginInViewModelFactory(
    private val loginInUseCase: LoginInWithEmailAndPasswordUseCase,
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val stringProvider: AppStringProvider,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        LoginInViewModel(
            loginInUseCase,
            validateEmailUseCase,
            validatePasswordUseCase,
            stringProvider,
        ) as T
}