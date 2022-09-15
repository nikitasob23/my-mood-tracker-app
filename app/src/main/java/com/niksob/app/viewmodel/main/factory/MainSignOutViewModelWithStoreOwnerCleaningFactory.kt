package com.niksob.app.viewmodel.main.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.app.viewmodel.main.MainActivitySignOutViewModelWithStoreOwnerCleaning
import com.niksob.domain.usecase.auth.LoadAuthorizeUserIdUseCase
import com.niksob.domain.usecase.auth.SignOutUseCase

class MainSignOutViewModelWithStoreOwnerCleaningFactory(
    private val loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
    private val signOutUseCase: SignOutUseCase,
    private val viewModelStoreOwner: ViewModelStoreOwner,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        MainActivitySignOutViewModelWithStoreOwnerCleaning(
            loadAuthorizeUserIdUseCase = loadAuthorizeUserIdUseCase,
            signOutUseCase = signOutUseCase,
            owner = viewModelStoreOwner,
        ) as T
}