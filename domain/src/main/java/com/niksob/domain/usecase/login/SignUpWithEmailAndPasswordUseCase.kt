package com.niksob.domain.usecase.login

import com.niksob.domain.data.dto.login.AuthCallbackDto
import com.niksob.domain.data.dto.login.LoginDataCallbackDto
import com.niksob.domain.data.repository.AuthRepository
import com.niksob.domain.model.LoginDataCallback

class SignUpWithEmailAndPasswordUseCase(
    private val repo: AuthRepository
) {
    fun execute(loginDataCallback: LoginDataCallback) {

        val loginDataDto = loginDataCallback.loginData.toDto()
        val callback = loginDataCallback.callback

        val loginDataCallbackDto = LoginDataCallbackDto(
            loginDataDto,
            AuthCallbackDto { responseDto ->

                val response = responseDto.toAuthResponse()
                callback.invoke(response)
            }
        )
        repo.register(loginDataCallbackDto)
    }
}