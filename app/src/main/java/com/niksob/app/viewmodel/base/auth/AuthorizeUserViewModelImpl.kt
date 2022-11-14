package com.niksob.app.viewmodel.base.auth

import androidx.lifecycle.ViewModel
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query
import com.niksob.domain.usecase.auth.loading_auth_user.LoadAuthorizeUserIdUseCase

open class AuthorizeUserViewModelImpl(
    private val loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
) : AuthorizeUserViewModel, ViewModel() {

    override fun loadAuthorizeUser(onLoadAuthorizeUserCompleted: (Query) -> Unit) {
        val callback = Callback<Query> { response -> onLoadAuthorizeUserCompleted(response) }
        loadAuthorizeUserIdUseCase.execute(callback)
    }
}