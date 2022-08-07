package com.niksob.data.storage.db.firebase.screen.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.niksob.data.provider.DbProvider
import com.niksob.data.storage.db.AuthStorage
import com.niksob.data.storage.provider.AppStringStorage
import com.niksob.domain.data.dto.LoginDataDto
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query
import com.niksob.domain.model.Uid


private const val SUCCESS_AUTH_REASON = "authorize_completed"
private const val FAILED_AUTH_REASON = "authorize_failed"
private const val SUCCESS_REGISTER_REASON = "registration_completed"
private const val FAILED_REGISTER_REASON = "registration_failed"
private const val SUCCESS_SIGN_OUT_REASON = "sign_out_completed"
private const val FAILED_SIGN_OUT_REASON = "sign_out_failed"
private const val EXCEPTION_MESSAGE_PREFIX = ". Exception message: "

class AuthFirebase(
    dbProvider: DbProvider,
    private val stringStorage: AppStringStorage,
) : AuthStorage {

    private val auth: FirebaseAuth = dbProvider.getAuth()

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
        failedReasonId: String,
        exception: Exception? = null
    ) {
        val resultQuery =
            if (isSuccessfulAuth)
                getAuthSuccessQuery(stringStorage.getString(successReasonId))
            else
                getAuthFailedQuery(
                    stringStorage.getString(failedReasonId) + EXCEPTION_MESSAGE_PREFIX + exception?.message
                )
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

    private fun getAuthSuccessQuery(reason: String) =
        Query(
            data = Uid(auth.currentUser?.uid!!),
            completed = true,
            reason = reason,
        )

    private fun getAuthFailedQuery(reason: String) =
        Query(reason = reason)
}