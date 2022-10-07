package com.niksob.data.storage.base.auth.authorizer

import com.niksob.domain.model.Query

interface Authorizer {
    fun auth(request: Query)
}
