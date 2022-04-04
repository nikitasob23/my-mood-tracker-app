package com.niksob.domain.model

data class Callback<T>(
    val invoke: (T) -> Unit,
)