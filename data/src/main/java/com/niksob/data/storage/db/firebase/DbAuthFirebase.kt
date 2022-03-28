package com.niksob.data.storage.db.firebase

import com.google.firebase.auth.FirebaseAuth
import com.niksob.data.storage.db.DbAuthStorage
import com.niksob.data.storage.string.StringStorage
import com.niksob.domain.data.dto.login.AuthResponseDto
import com.niksob.domain.data.dto.login.LoginDataCallbackDto

private const val SUCCESS_REASON = "authorize_completed"
private const val FAILED_REASON = "authorize_failed"

class DbAuthFirebase(
    private val auth: FirebaseAuth,
    private val stringStorage: StringStorage,
) : DbAuthStorage {

    override fun authorize(loginDataCallbackDto: LoginDataCallbackDto) {

        val loginData = loginDataCallbackDto.loginData

        auth.signInWithEmailAndPassword(loginData.email, loginData.password).addOnCompleteListener {
            val response = AuthResponseDto(
                success = true,
                reason = stringStorage.getString(SUCCESS_REASON)
            )
            loginDataCallbackDto.callback(response)

        }.addOnCanceledListener {
            val response = AuthResponseDto(
                success = false,
                reason = stringStorage.getString(FAILED_REASON)
            )
            loginDataCallbackDto.callback(response)
        }
    }

    override fun register(loginDataCallbackDto: LoginDataCallbackDto) {

        val loginData = loginDataCallbackDto.loginData

        auth.createUserWithEmailAndPassword(loginData.email, loginData.password).addOnCompleteListener {
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