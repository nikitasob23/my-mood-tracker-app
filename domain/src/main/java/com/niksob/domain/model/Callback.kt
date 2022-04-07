package com.niksob.domain.model

data class Callback<T>(
    val call: (T) -> Unit,
)