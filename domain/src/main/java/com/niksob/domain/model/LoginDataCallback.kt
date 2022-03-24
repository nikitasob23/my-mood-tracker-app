package com.niksob.domain.model


interface LoginDataCallback {
    fun getLoginData(): LoginData

    fun callback(response: AuthResponse)
}