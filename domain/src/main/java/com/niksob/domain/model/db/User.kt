package com.niksob.domain.model.db

import com.niksob.domain.data.dto.db.UserDto

data class User(
    val id: String,
    val email: String,
) {
    fun toDto() = UserDto(
        id = this.id,
        email = this.email,
    )
}
