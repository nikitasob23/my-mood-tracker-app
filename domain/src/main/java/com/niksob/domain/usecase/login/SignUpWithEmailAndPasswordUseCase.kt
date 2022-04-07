package com.niksob.domain.usecase.login

import com.niksob.domain.data.repository.AuthRepository
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query
import com.niksob.domain.model.LoginData

class SignUpWithEmailAndPasswordUseCase(
    private val repo: AuthRepository
) {
    fun execute(query: Query) {

        val loginData = query.data as LoginData
        val loginDataCallback = query.callback

        val queryDto = Query(
            data = loginData.toDto(),
            callback = Callback { queryDto ->

                val newQuery = Query(
                    data = queryDto.data,
                    completed = queryDto.completed,
                    reason = queryDto.reason,
                )
                loginDataCallback?.call?.invoke(newQuery)
            }
        )
        repo.register(queryDto)
    }
}