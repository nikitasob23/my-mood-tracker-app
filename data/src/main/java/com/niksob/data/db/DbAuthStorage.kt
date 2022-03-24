package com.niksob.data.db

import com.niksob.domain.data.dto.login.LoginDataCallbackDto

interface DbAuthStorage {
    fun authorize(loginDataCallbackDto: LoginDataCallbackDto)
}
