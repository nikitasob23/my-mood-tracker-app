package com.niksob.app.viewmodel.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query
import com.niksob.domain.usecase.auth.loading_auth_user.LoadAuthorizeUserIdUseCase
import com.niksob.domain.usecase.auth.sign_out.SignOutUseCase

open class MainActivityViewModelImpl(
    private val loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
    protected val signOutUseCase: SignOutUseCase,
) : MainActivityViewModel, ViewModel() {

    private val _loadAuthUserResponse = MutableLiveData<Query>()

    protected val _signOutResponse = MutableLiveData<Query>()

    override val loadAuthUserResponse: LiveData<Query> = _loadAuthUserResponse

    override val signOutResponse: LiveData<Query> = _signOutResponse

    override fun loadAuthorizeUserId() {

        val callback = Callback<Query> { query ->
            _loadAuthUserResponse.value = query
        }
        loadAuthorizeUserIdUseCase.execute(callback)
    }

    override fun signOut() {
        val callback = Callback<Query> { query ->
            _signOutResponse.value = query
        }
        signOutUseCase.execute(callback)
    }
}