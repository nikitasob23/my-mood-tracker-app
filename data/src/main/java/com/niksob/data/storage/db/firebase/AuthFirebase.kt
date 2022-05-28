package com.niksob.data.storage.db.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.niksob.data.storage.db.AuthStorage
import com.niksob.data.storage.string.AppStringStorage
import com.niksob.domain.data.dto.LoginDataDto
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query


private const val SUCCESS_AUTH_REASON = "authorize_completed"
private const val FAILED_AUTH_REASON = "authorize_failed"
private const val SUCCESS_REGISTER_REASON = "registration_completed"
private const val FAILED_REGISTER_REASON = "registration_failed"
private const val SUCCESS_SIGN_OUT_REASON = "sign_out_completed"
private const val FAILED_SIGN_OUT_REASON = "sign_out_failed"

class AuthFirebase(
    private val auth: FirebaseAuth,
    private val stringStorage: AppStringStorage,
) : AuthStorage {

    override fun authorize(query: Query) {
        val (email, password) = query.data as LoginDataDto

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { authResult ->
                onComplete(
                    isSuccessfulAuth = authResult.isSuccessful,
                    callback = query.callback!!,
                    successReasonId = SUCCESS_AUTH_REASON,
                    failedReasonId = FAILED_AUTH_REASON,
                )
            }
    }

    override fun register(query: Query) {
        val (email, password) = query.data as LoginDataDto

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { authResult ->
                onComplete(
                    isSuccessfulAuth = authResult.isSuccessful,
                    callback = query.callback!!,
                    successReasonId = SUCCESS_REGISTER_REASON,
                    failedReasonId = FAILED_REGISTER_REASON,
                )
            }
    }

    override fun signOut(callback: Callback<Query>) {
        auth.addAuthStateListener(onAuthStateChanged(callback))
        auth.signOut()
    }

    override fun loadAuthorizeUserId(callback: Callback<Query>) {
        onComplete(
            isSuccessfulAuth = auth.currentUser != null,
            callback = callback,
            successReasonId = SUCCESS_AUTH_REASON,
            failedReasonId = FAILED_AUTH_REASON,
        )
    }

    private fun onComplete(
        isSuccessfulAuth: Boolean,
        callback: Callback<Query>,
        successReasonId: String,
        failedReasonId: String
    ) {
        val resultQuery =
            if (isSuccessfulAuth)
                getAuthSuccessQuery(successReasonId)
            else
                getAuthFailedQuery(failedReasonId)
        callback.call(resultQuery)
    }

    private fun onAuthStateChanged(callback: Callback<Query>) =
        object : AuthStateListener {
            override fun onAuthStateChanged(currentAuth: FirebaseAuth) {
                val response =
                    if (auth.currentUser == null)
                        Query(
                            completed = true,
                            reason = stringStorage.getString(SUCCESS_SIGN_OUT_REASON),
                        )
                    else
                        Query(reason = stringStorage.getString(FAILED_SIGN_OUT_REASON))

                callback.call(response)
                auth.removeAuthStateListener(this)
            }
        }

    private fun getAuthSuccessQuery(reasonId: String) =
        Query(
            data = auth.currentUser?.uid!!,
            completed = true,
            reason = stringStorage.getString(reasonId),
        )

    private fun getAuthFailedQuery(reasonId: String) =
        Query(reason = stringStorage.getString(reasonId))
}