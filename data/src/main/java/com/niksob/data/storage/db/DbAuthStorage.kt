package com.niksob.data.storage.db

import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query

interface DbAuthStorage {
    fun authorize(query: Query)

    fun register(query: Query)

    fun signOut(callback: Callback<Query>)

    fun loadAuthorizeUserId(query: Query)
}
