package com.niksob.domain.usecase.loginin

import com.niksob.domain.data.dto.login.AuthResponseDto
import com.niksob.domain.data.dto.login.LoginDataDto
import com.niksob.domain.data.dto.login.LoginDataCallbackDto
import com.niksob.domain.data.repository.AuthRepository
import com.niksob.domain.model.AuthResponse
import com.niksob.domain.model.LoginData
import com.niksob.domain.model.LoginDataCallback

const val SUCCESS_REASON = "Successful authorize"
const val FAILED_REASON = "Failed authorize"

class LoginInUseCase(
    private val repo: AuthRepository
) {
    fun execute(loginDataCallback: LoginDataCallback) {

        val loginDataCallbackDto = object : LoginDataCallbackDto {
            override fun getLoginData(): LoginDataDto {
                val loginData = loginDataCallback.getLoginData()
                return loginData.toDto()
            }

            override fun callback(authResponseDto: AuthResponseDto) {
                val response = authResponseDto.toAuthResponse()
                loginDataCallback.callback(response)
            }
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