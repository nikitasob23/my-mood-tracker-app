package com.niksob.data.repository

import com.niksob.data.storage.base.user.UserStorage
import com.niksob.domain.data.repository.UserRepository
import com.niksob.domain.model.Query

class UserRepositoryImpl(
    private val storage: UserStorage
) : UserRepository {
    override fun add(request: Query) {
        storage.addUser(request)
    }

}
