package com.niksob.app.viewmodel.auth.loginin

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

    private fun getSucceedResponse(loginData: LoginData) =
        Query(
            data = loginData,
            completed = true,
            callback = Callback { query -> mutableResponse.value = query }
        )
}