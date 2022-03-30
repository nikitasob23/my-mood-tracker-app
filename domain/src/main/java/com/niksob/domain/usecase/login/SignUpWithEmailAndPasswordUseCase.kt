package com.niksob.domain.usecase.login

import com.niksob.domain.data.dto.login.LoginDataCallbackDto
import com.niksob.domain.data.repository.AuthRepository
import com.niksob.domain.model.LoginDataCallback

class SignUpWithEmailAndPasswordUseCase(
    private val repo: AuthRepository
) {
    fun execute(loginDataCallback: LoginDataCallback) {

        val loginDataDto = loginDataCallback.loginData.toDto()
        val loginDataCallbackDto = LoginDataCallbackDto(loginDataDto) { authResponseDto ->

            val response = authResponseDto.toAuthResponse()
            loginDataCallback.callback(response)
        }
        repo.register(loginDataCallbackDto)
    }
}