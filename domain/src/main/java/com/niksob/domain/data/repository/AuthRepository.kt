package com.niksob.domain.data.repository

import com.niksob.domain.data.dto.AuthResponseDto
import com.niksob.domain.data.dto.LoginDataDto

interface AuthRepository {
    fun authorize(loginData: LoginDataDto): AuthResponseDto
}