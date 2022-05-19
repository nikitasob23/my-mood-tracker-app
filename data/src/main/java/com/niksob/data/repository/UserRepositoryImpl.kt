package com.niksob.data.repository

import com.niksob.data.storage.db.UserStorage
import com.niksob.domain.data.repository.UserRepository
import com.niksob.domain.model.Query

class UserRepositoryImpl(
    private val storage: UserStorage
) : UserRepository {
    override fun add(query: Query) {
        storage.addUser(query)
    }

}
