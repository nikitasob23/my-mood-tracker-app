package com.niksob.domain.usecase.login

import com.niksob.domain.data.dto.login.AuthResponseDto
import com.niksob.domain.data.dto.login.LoginDataDto
import com.niksob.domain.data.dto.login.LoginDataCallbackDto
import com.niksob.domain.data.repository.AuthRepository
import com.niksob.domain.model.AuthResponse
import com.niksob.domain.model.LoginData
import com.niksob.domain.model.LoginDataCallback


class LoginInWithEmailAndPasswordUseCase(
    private val repo: AuthRepository
) {
    fun execute(loginDataCallback: LoginDataCallback) {

        val loginData = loginDataCallback.loginData

        val loginDataCallbackDto = LoginDataCallbackDto(loginData.toDto()) { authResponseDto ->
            val response = authResponseDto.toAuthResponse()
            loginDataCallback.callback(response)
        }

        repo.authorize(loginDataCallbackDto)
    }
}

fun LoginData.toDto() = LoginDataDto(
    email = this.email,
    password = this.password,
)

fun AuthResponseDto.toAuthResponse() = AuthResponse(
    success = this.success,
    reason = this.reason,
)