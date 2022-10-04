package com.niksob.domain.data.repository

import com.niksob.domain.model.Query

interface UserRepository {

    fun add(request: Query)
}
