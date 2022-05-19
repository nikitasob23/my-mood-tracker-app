package com.niksob.data.storage.db

import com.niksob.domain.model.Query

interface UserStorage {
    fun addUser(query: Query)
}