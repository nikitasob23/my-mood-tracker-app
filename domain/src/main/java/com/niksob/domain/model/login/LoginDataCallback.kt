package com.niksob.domain.model.login

data class LoginDataCallback(
    val loginData: LoginData,
    val callback: AuthCallback,
)