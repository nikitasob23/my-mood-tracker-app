package com.niksob.data.storage.auth.authorizer

import com.niksob.domain.model.Query

interface Authorizer {
    fun auth(request: Query)
}
