package com.niksob.data.storage.db

import com.niksob.domain.data.dto.db.UserCallbackDto

interface DbUserStorage {
    fun addUser(userCallback: UserCallbackDto)
}