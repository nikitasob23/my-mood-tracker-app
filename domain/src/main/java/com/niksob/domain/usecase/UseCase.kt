package com.niksob.domain.usecase

import com.niksob.domain.model.Query

interface UseCase {
    fun execute(request: Query)
}