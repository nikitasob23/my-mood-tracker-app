package com.niksob.domain.usecase.login

import com.niksob.domain.data.dto.login.AuthCallbackDto
import com.niksob.domain.data.repository.AuthRepository
import com.niksob.domain.model.login.AuthCallback

class LoadAuthorizeUserIdUseCase(
    private val authRepo: AuthRepository
) {

    fun execute(callback: AuthCallback) {

        val callbackDto = AuthCallbackDto { responseDto ->

            val response = responseDto.toAuthResponse()
            callback.invoke(response)
        }
        authRepo.loadAuthorizeUserId(callbackDto)
    }
}