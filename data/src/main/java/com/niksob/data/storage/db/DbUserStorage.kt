package com.niksob.data.storage.db

import com.niksob.domain.model.Query

interface DbUserStorage {
    fun addUser(query: Query)
}