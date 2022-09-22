package com.niksob.app.viewmodel.auth.signup.base

import androidx.lifecycle.LiveData
import com.niksob.domain.model.Query
import com.niksob.domain.model.User

interface SignUpViewModelWithNewUserAddition : SignUpViewModel {

    val userAdditionResponse: LiveData<Query>

    fun addUser(user: User)
}