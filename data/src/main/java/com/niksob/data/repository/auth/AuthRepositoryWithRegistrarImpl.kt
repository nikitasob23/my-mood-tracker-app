package com.niksob.data.repository.auth

import com.niksob.data.storage.base.auth.auth_registrar.AuthRegistrar
import com.niksob.domain.data.repository.auth.AuthRepositoryWithRegistrar
import com.niksob.domain.model.Query

class AuthRepositoryWithRegistrarImpl(
    private val registrar: AuthRegistrar,
) : AuthRepositoryWithRegistrar, AuthRepositoryWithAuthorizedUserIdLoaderImpl(loader = registrar) {

    override fun register(request: Query) {
        registrar.register(request)
    }
}