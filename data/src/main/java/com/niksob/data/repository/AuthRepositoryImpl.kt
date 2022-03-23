package com.niksob.data.repository

import com.niksob.data.db.DbAuthStorage
import com.niksob.domain.data.dto.AuthResponseDto
import com.niksob.domain.data.dto.LoginDataDto
import com.niksob.domain.data.repository.AuthRepository

class AuthRepositoryImpl(
    private val storage: DbAuthStorage
) : AuthRepository {
    override fun authorize(loginData: LoginDataDto): AuthResponseDto {
        return storage.authorize(loginData)
    }
}