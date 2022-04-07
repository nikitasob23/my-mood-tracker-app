package com.niksob.data.repository

import com.niksob.data.storage.db.DbAuthStorage
import com.niksob.domain.data.repository.AuthRepository
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query

class AuthRepositoryImpl(
    private val storage: DbAuthStorage
) : AuthRepository {

    override fun authorize(query: Query) {
        storage.authorize(query)
    }

    override fun register(query: Query) {
        storage.register(query)
    }

    override fun loginOut(callback: Callback<Query>) {
        storage.signOut(callback)
    }

    override fun loadAuthorizeUserId(query: Query) {
        storage.loadAuthorizeUserId(query)
    }
}