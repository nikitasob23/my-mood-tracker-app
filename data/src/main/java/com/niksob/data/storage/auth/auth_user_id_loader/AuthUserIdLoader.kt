package com.niksob.data.storage.auth.auth_user_id_loader

import com.niksob.data.storage.auth.signout.SignOut
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query

interface AuthUserIdLoader : SignOut {
    fun loadAuthorizeUserId(callback: Callback<Query>)
}