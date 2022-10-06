package com.niksob.domain.data.repository.auth

import com.niksob.domain.model.Query

interface AuthRepositoryWithAuthorizer {
    fun authorize(request: Query)
}