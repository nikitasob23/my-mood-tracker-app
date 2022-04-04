package com.niksob.domain.model.login

data class AuthResponse(
    val success: Boolean,
    var uid: String? = null,
    val reason: String,
)
