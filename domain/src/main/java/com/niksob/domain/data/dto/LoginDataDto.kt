package com.niksob.domain.data.dto

import com.niksob.domain.model.LoginData


data class LoginDataDto(
    val email: String,
    val password: String,
) {
    fun fromDto() = LoginData(
        email = this.email,
        password = this.password,
    )
}
