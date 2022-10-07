package com.niksob.data.storage.base.user

import com.niksob.domain.model.Query

interface UserStorage {
    fun addUser(request: Query)
}