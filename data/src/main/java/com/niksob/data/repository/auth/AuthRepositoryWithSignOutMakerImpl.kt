package com.niksob.data.repository.auth

import com.niksob.data.storage.auth.signout.SignOutMaker
import com.niksob.domain.data.repository.auth.AuthRepositoryWithSignOutMaker
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query

open class AuthRepositoryWithSignOutMakerImpl(
    private val signOutMaker: SignOutMaker,
) : AuthRepositoryWithSignOutMaker, AuthRepositoryWithAuthorizerImpl(authorizer = signOutMaker) {

    override fun signOut(callback: Callback<Query>) {
        signOutMaker.signOut(callback)
    }
}