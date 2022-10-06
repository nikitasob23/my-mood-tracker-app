package com.niksob.domain.usecase.auth

import com.niksob.domain.data.repository.auth.AuthRepositoryWithSignOutMaker
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query

class SignOutUseCase(
    private val repo: AuthRepositoryWithSignOutMaker,
) {
    fun execute(callback: Callback<Query>) {
        repo.signOut(callback)
    }
}