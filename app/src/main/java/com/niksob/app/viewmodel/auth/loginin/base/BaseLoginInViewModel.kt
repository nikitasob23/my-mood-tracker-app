package com.niksob.app.viewmodel.auth.loginin.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.niksob.domain.model.Callback
import com.niksob.domain.model.LoginData
import com.niksob.domain.model.Query
import com.niksob.domain.usecase.auth.LoginInWithEmailAndPasswordUseCase

open class BaseLoginInViewModel(
    private val loginInWithEmailAndPasswordUseCase: LoginInWithEmailAndPasswordUseCase,
) : LoginInViewModel, ViewModel() {

    override val response: LiveData<Query> get() = mutableResponse

    protected val mutableResponse = MutableLiveData<Query>()

    override fun doLoginIn(loginData: LoginData) {

        val response = getSucceedResponse(loginData)
        loginInWithEmailAndPasswordUseCase.execute(response)
    }

    protected open fun onLoginInCompleted(response: Query) {
        mutableResponse.value = response
    }

    private fun getSucceedResponse(loginData: LoginData) =
        Query(
            data = loginData,
            completed = true,
            callback = Callback { response -> onLoginInCompleted(response) }
        )
}