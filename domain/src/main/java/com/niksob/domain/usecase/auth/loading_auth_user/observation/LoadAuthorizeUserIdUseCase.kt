package com.niksob.domain.usecase.auth.loading_auth_user.observation

import com.niksob.domain.data.converter.base.DtoConverter
import com.niksob.domain.data.dto.UidDto
import com.niksob.domain.data.repository.auth.observable.AuthRepository
import com.niksob.domain.model.Uid

class LoadAuthorizeUserIdUseCase(
    private val authRepository: AuthRepository,
    private val userIdConverter: DtoConverter<Uid, UidDto>,
) {
    fun execute() = authRepository.loadAuthorizeUserId()
        .map(userIdConverter::fromDto)
}