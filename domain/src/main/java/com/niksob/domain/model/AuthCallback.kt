package com.niksob.domain.model

data class AuthCallback(
    val invoke: (AuthResponse) -> Unit,
)
