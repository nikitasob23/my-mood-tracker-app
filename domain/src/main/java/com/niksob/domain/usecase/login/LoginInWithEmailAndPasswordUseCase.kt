package com.niksob.domain.usecase.login

import com.niksob.domain.data.dto.login.AuthCallbackDto
import com.niksob.domain.data.dto.login.AuthResponseDto
import com.niksob.domain.data.dto.login.LoginDataDto
import com.niksob.domain.data.dto.login.LoginDataCallbackDto
import com.niksob.domain.data.repository.AuthRepository
import com.niksob.domain.model.login.AuthResponse
import com.niksob.domain.model.login.LoginData
import com.niksob.domain.model.login.LoginDataCallback


class LoginInWithEmailAndPasswordUseCase(
    private val repo: AuthRepository
) {
    fun execute(loginDataCallback: LoginDataCallback) {

        val loginData = loginDataCallback.loginData
        val callback = loginDataCallback.callback

        val loginDataCallbackDto = LoginDataCallbackDto(
            loginData.toDto(),
            AuthCallbackDto { responseDto ->

                val response = responseDto.toAuthResponse()
                callback.invoke(response)
            }
        )
        repo.authorize(loginDataCallbackDto)
    }
}

fun LoginData.toDto() = LoginDataDto(
    email = this.email,
    password = this.password,
)

fun AuthResponseDto.toAuthResponse() = AuthResponse(
    success = this.success,
    uid = this.uid,
    reason = this.reason,
)