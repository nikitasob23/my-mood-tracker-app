package com.niksob.domain.data.dto.login


interface LoginDataCallbackDto {
    fun getLoginData(): LoginDataDto

    fun callback(authResponseDto: AuthResponseDto)
}