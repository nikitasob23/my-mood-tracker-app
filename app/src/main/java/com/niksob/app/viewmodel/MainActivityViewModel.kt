package com.niksob.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query
import com.niksob.domain.usecase.auth.LoadAuthorizeUserIdUseCase
import com.niksob.domain.usecase.auth.SignOutUseCase

class MainActivityViewModel(
    private val loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
    private val signOutUseCase: SignOutUseCase,
) : ViewModel() {

    private val _loadAuthUserResponse = MutableLiveData<Query>()

    private val _signOutResponse = MutableLiveData<Query>()

    val loadAuthUserResponse: LiveData<Query> = _loadAuthUserResponse

    val signOutResponse: LiveData<Query> = _signOutResponse

    fun loadAuthorizeUserId() {

        val callback = Callback<Query> { query ->
            _loadAuthUserResponse.value = query
        }
        loadAuthorizeUserIdUseCase.execute(callback)
    }

    fun signOut() {
        val callback = Callback<Query> { query ->
            _signOutResponse.value = query
        }
        signOutUseCase.execute(callback)
    }
}