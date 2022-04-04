package com.niksob.domain.model.login

data class AuthCallback(
    val invoke: (AuthResponse) -> Unit,
)
