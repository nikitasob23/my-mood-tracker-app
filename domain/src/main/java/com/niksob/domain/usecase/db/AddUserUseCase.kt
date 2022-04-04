package com.niksob.domain.usecase.db

import com.niksob.domain.data.dto.db.UserCallbackDto
import com.niksob.domain.data.repository.UserRepository
import com.niksob.domain.model.Callback
import com.niksob.domain.model.db.UserCallback

class AddUserUseCase(
    private val userRepo: UserRepository
) {

    fun execute(userCallback: UserCallback) {
        val user = userCallback.user
        val callback = userCallback.callback

        val userCallbackDto = UserCallbackDto(
            user.toDto(),
            Callback { responseDto ->

                val response = responseDto.fromDto()
                callback.invoke(response)
            }
        )

        userRepo.add(userCallbackDto)
    }
}