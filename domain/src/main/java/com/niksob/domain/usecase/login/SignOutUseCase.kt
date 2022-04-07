package com.niksob.domain.usecase.login

import com.niksob.domain.data.repository.AuthRepository
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query

class SignOutUseCase(
    private val repo: AuthRepository
) {

    fun execute(callback: Callback<Query>) {
        repo.loginOut(callback)
    }
}