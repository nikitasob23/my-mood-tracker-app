package com.niksob.app.viewmodel.base.auth.observable

import androidx.lifecycle.ViewModel
import com.niksob.domain.usecase.auth.loading_auth_user.observation.LoadAuthorizeUserIdUseCase

open class BaseAuthorizeUserViewModelImpl(
    private val loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
) : AuthorizeUserViewModel, ViewModel() {

    override fun loadAuthorizeUser() = loadAuthorizeUserIdUseCase.execute()
}