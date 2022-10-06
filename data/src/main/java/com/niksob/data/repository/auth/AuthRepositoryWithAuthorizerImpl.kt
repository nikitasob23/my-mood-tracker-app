package com.niksob.data.repository.auth

import com.niksob.data.storage.auth.authorizer.Authorizer
import com.niksob.domain.data.repository.auth.AuthRepositoryWithAuthorizer
import com.niksob.domain.model.Query

open class AuthRepositoryWithAuthorizerImpl(
    private val authorizer: Authorizer,
) : AuthRepositoryWithAuthorizer {

    override fun authorize(request: Query) {
        authorizer.auth(request)
    }
}