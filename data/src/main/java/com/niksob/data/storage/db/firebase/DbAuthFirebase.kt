package com.niksob.data.storage.db.firebase

import com.google.firebase.auth.FirebaseAuth
import com.niksob.data.storage.db.DbAuthStorage
import com.niksob.data.storage.string.StringStorage
import com.niksob.domain.data.dto.login.AuthCallbackDto
import com.niksob.domain.data.dto.login.AuthResponseDto
import com.niksob.domain.data.dto.login.LoginDataCallbackDto

private const val SUCCESS_AUTH_REASON = "authorize_completed"
private const val FAILED_AUTH_REASON = "authorize_failed"
private const val SUCCESS_REGISTER_REASON = "registration_completed"
private const val FAILED_REGISTER_REASON = "registration_failed"

class DbAuthFirebase(
    private val auth: FirebaseAuth,
    private val stringStorage: StringStorage,
) : DbAuthStorage {

    override fun authorize(loginDataCallbackDto: LoginDataCallbackDto) {

        val loginData = loginDataCallbackDto.loginData
        val callback = loginDataCallbackDto.callback

        auth.signInWithEmailAndPassword(loginData.email, loginData.password).addOnCompleteListener {
            val response = AuthResponseDto(
                success = true,
                uid = auth.currentUser!!.uid,
                reason = stringStorage.getString(SUCCESS_AUTH_REASON)
            )
            callback.invoke(response)

        }.addOnCanceledListener {
            val response = AuthResponseDto(
                success = false,
                reason = stringStorage.getString(FAILED_AUTH_REASON)
            )
            callback.invoke(response)
        }
    }

    override fun register(loginDataCallbackDto: LoginDataCallbackDto) {

        val loginData = loginDataCallbackDto.loginData
        val callback = loginDataCallbackDto.callback

        auth.createUserWithEmailAndPassword(loginData.email, loginData.password).addOnCompleteListener {
            val response = AuthResponseDto(
                success = true,
                uid = auth.currentUser!!.uid,
                reason = stringStorage.getString(SUCCESS_REGISTER_REASON)
            )
            callback.invoke(response)

        }.addOnCanceledListener {
            val response = AuthResponseDto(
                success = false,
                reason = stringStorage.getString(FAILED_REGISTER_REASON)
            )
            callback.invoke(response)
        }
    }

    override fun loadAuthorizeUserId(callback: AuthCallbackDto) {

        val response = if (auth.currentUser == null) {

            AuthResponseDto(
                success = false,
                reason = stringStorage.getString(FAILED_AUTH_REASON)
            )
        } else {

            AuthResponseDto(
                success = true,
                uid = auth.currentUser!!.uid,
                reason = stringStorage.getString(SUCCESS_AUTH_REASON)
            )
        }
        callback.invoke(response)
    }
}