package com.niksob.domain.data.dto.db

import com.niksob.domain.model.Callback

data class UserCallbackDto(
    val user: UserDto,
    val callback: Callback<UserResponseDto>
)
