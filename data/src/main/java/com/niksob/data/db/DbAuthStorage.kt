package com.niksob.data.db

import com.niksob.domain.data.dto.AuthResponseDto
import com.niksob.domain.data.dto.LoginDataDto

interface DbAuthStorage {
    fun authorize(loginData: LoginDataDto) : AuthResponseDto
}
