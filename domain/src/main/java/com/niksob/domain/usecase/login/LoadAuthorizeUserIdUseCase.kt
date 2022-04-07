package com.niksob.domain.usecase.login

import com.niksob.domain.data.repository.AuthRepository
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query

class LoadAuthorizeUserIdUseCase(
    private val authRepo: AuthRepository
) {

    fun execute(query: Query) {

        val queryCallback = query.callback

        val queryDto = Query(
            callback = Callback { queryDto ->
                val newQuery = Query(
                    data = queryDto.data,
                    completed = queryDto.completed,
                    reason = queryDto.reason,
                )
                queryCallback?.call?.invoke(newQuery)
            }
        )
        authRepo.loadAuthorizeUserId(queryDto)
    }
}