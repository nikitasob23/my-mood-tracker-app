package com.niksob.data.repository

import com.niksob.data.storage.db.AuthStorage
import com.niksob.domain.data.repository.AuthRepository
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query

class AuthRepositoryImpl(
    private val storage: AuthStorage
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

    override fun loadAuthorizeUserId(callback: Callback<Query>) {
        storage.loadAuthorizeUserId(callback)
    }
}