package com.niksob.domain.model.db

import com.niksob.domain.model.Callback

data class UserCallback(
    val user: User,
    val callback: Callback<UserAdditionResponse>
)
