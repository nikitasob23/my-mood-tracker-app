package com.niksob.data.storage.base.auth.auth_user_id_loader

import com.niksob.data.storage.base.auth.signout.SignOutMaker
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query

interface AuthorizedUserIdLoader : SignOutMaker {
    fun loadAuthorizeUserId(callback: Callback<Query>)
}