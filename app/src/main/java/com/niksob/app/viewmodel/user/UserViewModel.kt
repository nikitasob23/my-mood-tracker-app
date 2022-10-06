package com.niksob.app.viewmodel.user

import androidx.lifecycle.LiveData
import com.niksob.domain.model.Query
import com.niksob.domain.model.User

interface UserViewModel {

    val userAdditionResponse: LiveData<Query>

    fun addUser(user: User)
}