package com.niksob.app.viewmodel.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query
import com.niksob.domain.model.User
import com.niksob.domain.usecase.db.AddUserUseCase

open class UserViewModelWithAddition(
    private val addUserUseCase: AddUserUseCase,
) : UserViewModel, ViewModel() {

    override val userAdditionResponse: LiveData<Query>
        get() = mutableUserAdditionResponse

    protected val mutableUserAdditionResponse = MutableLiveData<Query>()

    override fun addUser(user: User) {
        val response = toUserAdditionResponse(user)
        addUserUseCase.execute(response)
    }

    protected open fun onUserAdditionCompleted(response: Query) {
        mutableUserAdditionResponse.value = response
    }

    private fun toUserAdditionResponse(user: User) =
        Query(
            data = user,
            callback = Callback { response -> onUserAdditionCompleted(response) }
        )
}