package com.niksob.data.repository

import com.niksob.data.db.DbAuthStorage
import com.niksob.domain.data.dto.login.LoginDataCallbackDto
import com.niksob.domain.data.repository.AuthRepository

class AuthRepositoryImpl(
    private val storage: DbAuthStorage
) : AuthRepository {

    override fun authorize(callback: LoginDataCallbackDto) {
        storage.authorize(callback)
    }
}