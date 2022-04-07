package com.niksob.presentation.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.niksob.domain.usecase.login.LoadAuthorizeUserIdUseCase
import com.niksob.presentation.viewmodel.MainActivityViewModel

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(
    private val loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        MainActivityViewModel(loadAuthorizeUserIdUseCase) as T
}