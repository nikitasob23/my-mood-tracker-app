package com.niksob.domain.data.dto

import com.niksob.domain.model.Uid
import com.niksob.domain.model.User

data class UserDto(
    val id: Uid,
    val email: String,
)
