package com.niksob.data.storage.base.auth.auth_registrar

import com.niksob.data.storage.base.auth.auth_user_id_loader.AuthorizedUserIdLoader
import com.niksob.domain.model.Query

interface AuthRegistrar : AuthorizedUserIdLoader {
    fun register(request: Query)
}