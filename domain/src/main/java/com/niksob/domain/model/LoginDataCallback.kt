package com.niksob.domain.model

data class LoginDataCallback(
    val loginData: LoginData,
    val callback: AuthCallback,
)