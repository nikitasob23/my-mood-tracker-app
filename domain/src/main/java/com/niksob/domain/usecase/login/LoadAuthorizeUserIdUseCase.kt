package com.niksob.domain.usecase.login

import com.niksob.domain.data.repository.AuthRepository
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query

class LoadAuthorizeUserIdUseCase(
    private val authRepo: AuthRepository
) {

    fun execute(callback: Callback<Query>) {

        val callbackDto = Callback<Query> { queryDto ->
            val newQuery = Query(
                data = queryDto.data,
                completed = queryDto.completed,
                reason = queryDto.reason,
            )
            callback.call(newQuery)
        }
        authRepo.loadAuthorizeUserId(callbackDto)
    }
}