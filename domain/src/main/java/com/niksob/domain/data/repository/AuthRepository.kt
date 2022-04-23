package com.niksob.domain.data.repository

import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query

interface AuthRepository {
    fun authorize(query: Query)

    fun register(query: Query)

    fun loginOut(callback: Callback<Query>)

    fun loadAuthorizeUserId(callback: Callback<Query>)

}