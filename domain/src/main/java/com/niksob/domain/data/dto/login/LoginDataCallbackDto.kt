package com.niksob.domain.data.dto.login

data class LoginDataCallbackDto(
    val loginData: LoginDataDto,
    val callback: AuthCallbackDto,
)
