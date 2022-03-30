package com.niksob.domain.model

data class AuthResponse(
    val success: Boolean,
    var uid: String? = null,
    val reason: String,
)
