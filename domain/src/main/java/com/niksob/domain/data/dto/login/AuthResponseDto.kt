package com.niksob.domain.data.dto.login

data class AuthResponseDto(
    val success: Boolean,
    var uid: String? = null,
    val reason: String,
)
