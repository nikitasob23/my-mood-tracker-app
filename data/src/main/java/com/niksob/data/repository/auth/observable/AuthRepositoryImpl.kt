package com.niksob.data.repository.auth.observable

import com.niksob.data.storage.base.auth.observable.AuthStorage
import com.niksob.domain.data.repository.auth.observable.AuthRepository

class AuthRepositoryImpl(
    private val storage: AuthStorage,
) : AuthRepository {

    override fun loadAuthorizeUserId() = storage.loadAuthorizeUserId()
}