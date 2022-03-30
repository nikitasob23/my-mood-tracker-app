package com.niksob.domain.data.repository

import com.niksob.domain.data.dto.login.AuthCallbackDto
import com.niksob.domain.data.dto.login.LoginDataCallbackDto

interface AuthRepository {
    fun authorize(callback: LoginDataCallbackDto)

    fun register(callback: LoginDataCallbackDto)

    fun loadAuthorizeUserId(callback: AuthCallbackDto)
}