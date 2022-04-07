package com.niksob.domain.data.dto

import com.niksob.domain.model.User

data class UserDto(
    val id: String,
    val email: String,
) {
    fun fromDto() = User(
        id = this.id,
        email = this.email,
    )
}
