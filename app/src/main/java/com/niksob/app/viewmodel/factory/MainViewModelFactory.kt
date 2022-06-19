package com.niksob.app.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.niksob.domain.usecase.auth.LoadAuthorizeUserIdUseCase
import com.niksob.app.viewmodel.MainActivityViewModel
import com.niksob.domain.usecase.auth.SignOutUseCase

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(
    private val loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
    private val signOutUseCase: SignOutUseCase,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        MainActivityViewModel(loadAuthorizeUserIdUseCase, signOutUseCase) as T
}