package com.niksob.data.storage.db.firebase

import com.google.android.gms.tasks.OnCanceledListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.niksob.data.storage.db.DbAuthStorage
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

class DbAuthFirebase(
    private val auth: FirebaseAuth,
    private val stringStorage: AppStringStorage,
) : DbAuthStorage {

    override fun authorize(query: Query) {
        initOnAuthStateListener(query.callback!!, SUCCESS_AUTH_REASON)
        val (email, password) = query.data as LoginDataDto

        auth.signInWithEmailAndPassword(email, password)
            .addOnCanceledListener { onDataLoadCanceled(query.callback!!, FAILED_AUTH_REASON) }
    }

    override fun register(query: Query) {
        initOnAuthStateListener(query.callback!!, SUCCESS_REGISTER_REASON)
        val (email, password) = query.data as LoginDataDto

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCanceledListener { onDataLoadCanceled(query.callback!!, FAILED_REGISTER_REASON) }
    }

    override fun signOut(callback: Callback<Query>) {
        auth.addAuthStateListener(object : AuthStateListener {
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
        })
        auth.signOut()
    }

    override fun loadAuthorizeUserId(callback: Callback<Query>) {

        val currentUser = auth.currentUser

        val response =
            if (currentUser == null)
                Query(reason = stringStorage.getString(FAILED_AUTH_REASON))
            else
                Query(
                    data = currentUser.uid,
                    completed = true,
                    reason = stringStorage.getString(SUCCESS_AUTH_REASON),
                )
        callback.call(response)
    }

    private fun onDataLoadCanceled(callback: Callback<Query>, reason: String): OnCanceledListener {
        return OnCanceledListener {

            val response = Query(reason)
            callback.call(response)
        }
    }

    private fun initOnAuthStateListener(callback: Callback<Query>, reason: String) {
        auth.addAuthStateListener(object : AuthStateListener {

            override fun onAuthStateChanged(currentFirebase: FirebaseAuth) {
                if (auth.currentUser == null) {
                    return
                }

                val response = Query(
                    data = auth.currentUser?.uid,
                    completed = true,
                    reason = stringStorage.getString(reason),
                )

                callback.call(response)
                auth.removeAuthStateListener(this)
            }
        })
    }
}