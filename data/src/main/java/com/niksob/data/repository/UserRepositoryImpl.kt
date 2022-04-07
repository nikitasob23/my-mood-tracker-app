package com.niksob.data.repository

import com.niksob.data.storage.db.DbUserStorage
import com.niksob.domain.data.repository.UserRepository
import com.niksob.domain.model.Query

class UserRepositoryImpl(
    private val storage: DbUserStorage
) : UserRepository {
    override fun add(query: Query) {
        storage.addUser(query)
    }

}
