package com.niksob.domain.data.dto.login

data class AuthCallbackDto(
    val invoke: (AuthResponseDto) -> Unit,
)
