package com.niksob.app.viewmodel.auth.signup.base.useraddition

import androidx.lifecycle.LiveData
import com.niksob.app.viewmodel.auth.signup.base.signup.SignUpViewModel
import com.niksob.domain.model.Query
import com.niksob.domain.model.User

interface SignUpViewModelWithNewUserAddition : SignUpViewModel {

    val userAdditionResponse: LiveData<Query>

    fun addUser(user: User)
}