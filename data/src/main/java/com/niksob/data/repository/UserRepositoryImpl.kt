package com.niksob.data.repository

import com.niksob.data.storage.db.DbUserStorage
import com.niksob.domain.data.dto.db.UserCallbackDto
import com.niksob.domain.data.repository.UserRepository

class UserRepositoryImpl(
    private val storage: DbUserStorage
) : UserRepository {
    override fun add(userCallback: UserCallbackDto) {
        storage.addUser(userCallback)
    }

}
