package com.niksob.domain.model

import com.niksob.domain.data.dto.UserDto

data class User(
    val id: Uid,
    val email: String,
) {
    fun toDto() = UserDto(
        id = this.id,
        email = this.email,
    )

    fun fromDto() = User(
        id = this.id,
        email = this.email,
    )
}
