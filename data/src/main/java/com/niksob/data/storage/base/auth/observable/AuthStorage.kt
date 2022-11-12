package com.niksob.data.storage.base.auth.observable

import com.niksob.domain.data.dto.UidDto
import io.reactivex.Single

interface AuthStorage {
    fun loadAuthorizeUserId(): Single<UidDto>
}