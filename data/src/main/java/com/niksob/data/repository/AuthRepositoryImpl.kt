package com.niksob.data.repository

import com.niksob.data.storage.db.DbAuthStorage
import com.niksob.domain.data.dto.login.AuthCallbackDto
import com.niksob.domain.data.dto.login.LoginDataCallbackDto
import com.niksob.domain.data.repository.AuthRepository

class AuthRepositoryImpl(
    private val storage: DbAuthStorage
) : AuthRepository {

    override fun authorize(callback: LoginDataCallbackDto) {
        storage.authorize(callback)
    }

    override fun register(callback: LoginDataCallbackDto) {
        storage.register(callback)
    }

    override fun loadAuthorizeUserId(callback: AuthCallbackDto) {
        storage.loadAuthorizeUserId(callback)
    }
}