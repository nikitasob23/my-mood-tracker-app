package com.niksob.domain.usecase.db

import com.niksob.domain.data.repository.UserRepository
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query
import com.niksob.domain.model.User

class AddUserUseCase(
    private val userRepo: UserRepository
) {

    fun execute(query: Query) {

        val userQueryCallback = query.callback

        val queryDto = Query(
            data = (query.data as User).toDto(),
            callback = Callback { queryDto ->

                val user = queryDto.data?.let { queryDto.data as User }

                val newQuery = Query(
                    data = user?.fromDto(),
                    completed = queryDto.completed,
                    reason = queryDto.reason,
                )
                userQueryCallback?.call?.invoke(newQuery)
            }
        )

        userRepo.add(queryDto)
    }
}