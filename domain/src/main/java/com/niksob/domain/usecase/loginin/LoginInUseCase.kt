package com.niksob.domain.usecase.loginin

import com.niksob.domain.data.dto.LoginDataDto
import com.niksob.domain.model.LoginData
import com.niksob.domain.data.repository.AuthRepository
import com.niksob.domain.model.AuthResponse

class LoginInUseCase(
    private val repo: AuthRepository
) {
    fun execute(loginData: LoginData): AuthResponse {
        val loginDataDto = LoginDataDto(
            email = loginData.email,
            password = loginData.password,
        )
        val responseDto = repo.authorize(loginDataDto)

        return AuthResponse(
            success = responseDto.success,
            reason = responseDto.reason
        )
    }
}