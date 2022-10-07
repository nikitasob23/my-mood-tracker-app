package com.niksob.data.repository.auth

import com.niksob.data.storage.base.auth.auth_user_id_loader.AuthorizedUserIdLoader
import com.niksob.domain.data.repository.auth.AuthRepositoryWithAuthorizedUserIdLoader
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query

open class AuthRepositoryWithAuthorizedUserIdLoaderImpl(
    private val loader: AuthorizedUserIdLoader,
) : AuthRepositoryWithAuthorizedUserIdLoader, AuthRepositoryWithSignOutMakerImpl(signOutMaker = loader) {

    override fun loadAuthorizeUserId(callback: Callback<Query>) {
        loader.loadAuthorizeUserId(callback)
    }
}