package com.niksob.domain.data.repository

import com.niksob.domain.data.dto.db.UserCallbackDto

interface UserRepository {

    fun add(userCallback: UserCallbackDto)
}
