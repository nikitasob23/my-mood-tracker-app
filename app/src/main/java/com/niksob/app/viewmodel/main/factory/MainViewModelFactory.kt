package com.niksob.app.viewmodel.main.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.domain.usecase.auth.LoadAuthorizeUserIdUseCase
import com.niksob.app.viewmodel.main.MainActivityViewModelImpl
import com.niksob.domain.usecase.auth.SignOutUseCase

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(
    private val loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
    private val signOutUseCase: SignOutUseCase,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        MainActivityViewModelImpl(
            loadAuthorizeUserIdUseCase = loadAuthorizeUserIdUseCase,
            signOutUseCase = signOutUseCase,
        ) as T
}