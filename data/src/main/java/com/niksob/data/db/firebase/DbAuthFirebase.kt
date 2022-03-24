package com.niksob.data.db.firebase

import com.google.firebase.auth.FirebaseAuth
import com.niksob.data.db.DbAuthStorage
import com.niksob.domain.data.dto.login.AuthResponseDto
import com.niksob.domain.data.dto.login.LoginDataCallbackDto
import com.niksob.domain.usecase.loginin.FAILED_REASON
import com.niksob.domain.usecase.loginin.SUCCESS_REASON

class DbAuthFirebase(
    private val auth: FirebaseAuth
) : DbAuthStorage {

    override fun authorize(loginDataCallbackDto: LoginDataCallbackDto) {

        val email = loginDataCallbackDto.getLoginData().email
        val password = loginDataCallbackDto.getLoginData().password

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            val response = AuthResponseDto(
                success = true,
                reason = SUCCESS_REASON
            )
            loginDataCallbackDto.callback(response)

        }.addOnCanceledListener {
            val response = AuthResponseDto(
                success = false,
                reason = FAILED_REASON
            )
            loginDataCallbackDto.callback(response)
        }
    }
}