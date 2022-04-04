package com.niksob.domain.data.dto.db

import com.niksob.domain.model.db.UserAdditionResponse

data class UserResponseDto(
    val success: Boolean,
    val reason: String,
) {
    fun fromDto() = UserAdditionResponse(
        success = this.success,
        reason = this.reason,
    )
}
