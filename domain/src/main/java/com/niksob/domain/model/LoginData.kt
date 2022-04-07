package com.niksob.domain.model

import com.niksob.domain.data.dto.LoginDataDto


data class LoginData(
    val email: String,
    val password: String,
) {
    fun toDto() = LoginDataDto(
        email = this.email,
        password = this.password,
    )
}
