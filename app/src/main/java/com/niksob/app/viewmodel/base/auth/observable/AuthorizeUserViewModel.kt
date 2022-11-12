package com.niksob.app.viewmodel.base.auth.observable

import com.niksob.domain.model.Uid
import io.reactivex.Single

interface AuthorizeUserViewModel {
    fun loadAuthorizeUser(): Single<Uid>
}