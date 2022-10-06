package com.niksob.domain.data.repository.auth

import com.niksob.domain.model.Query

interface AuthRepositoryWithRegistrar : AuthRepositoryWithAuthorizedUserIdLoader {
    fun register(request: Query)
}