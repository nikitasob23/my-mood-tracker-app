package com.niksob.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query
import com.niksob.domain.usecase.login.LoadAuthorizeUserIdUseCase

class MainActivityViewModel(
    private val loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase
) : ViewModel() {

    private val responseLive = MutableLiveData<Query>()

    val response: LiveData<Query> = responseLive

    fun loadAuthorizeUserId() {

        val callback = Callback<Query> { query ->
            responseLive.value = query
        }
        loadAuthorizeUserIdUseCase.execute(callback)
    }
}