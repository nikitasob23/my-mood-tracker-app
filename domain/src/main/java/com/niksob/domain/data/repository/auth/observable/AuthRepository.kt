package com.niksob.domain.data.repository.auth.observable

import com.niksob.domain.data.dto.UidDto
import io.reactivex.Single

interface AuthRepository {
    fun loadAuthorizeUserId(): Single<UidDto>
}