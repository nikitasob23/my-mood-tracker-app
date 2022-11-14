package com.niksob.domain.usecase.auth.login_in

import com.niksob.domain.data.repository.auth.AuthRepositoryWithAuthorizer
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query
import com.niksob.domain.model.LoginData


class LoginInWithEmailAndPasswordUseCase(
    private val repo: AuthRepositoryWithAuthorizer
) {
    fun execute(query: Query) {

        val queryCallback = query.callback
        val loginData = query.data as LoginData

        val queryDto = Query(
            data = loginData.toDto(),
            callback = Callback { queryDto ->

                val fromDtoQuery = Query(
                    data = queryDto.data,
                    completed = queryDto.completed,
                    reason = queryDto.reason,
                )
                queryCallback?.call?.invoke(fromDtoQuery)
            }
        )

        repo.authorize(queryDto)
    }
}