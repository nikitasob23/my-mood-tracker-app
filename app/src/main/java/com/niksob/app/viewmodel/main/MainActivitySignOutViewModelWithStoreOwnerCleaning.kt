package com.niksob.app.viewmodel.main

import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query
import com.niksob.domain.usecase.auth.LoadAuthorizeUserIdUseCase
import com.niksob.domain.usecase.auth.SignOutUseCase

class MainActivitySignOutViewModelWithStoreOwnerCleaning(
    loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
    signOutUseCase: SignOutUseCase,
    private val owner: ViewModelStoreOwner,
) : MainActivityViewModelImpl(
    loadAuthorizeUserIdUseCase,
    signOutUseCase,
) {
    override fun signOut() {
        val callback = Callback<Query> { response ->
            owner.viewModelStore.clear()
            _signOutResponse.value = response
        }
        signOutUseCase.execute(callback)
    }
}