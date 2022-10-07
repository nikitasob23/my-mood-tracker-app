package com.niksob.data.storage.firebase.auth.authorizer

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.niksob.data.base.OnCompletedAction
import com.niksob.data.provider.AuthProvider
import com.niksob.data.storage.base.auth.authorizer.Authorizer
import com.niksob.domain.data.dto.LoginDataDto
import com.niksob.domain.model.Query
import com.niksob.domain.model.Uid

open class FirebaseAuthorizer(
    authProvider: AuthProvider,
    protected val authOnCompletedAction: OnCompletedAction,
) : Authorizer {

    protected val auth: FirebaseAuth = authProvider.auth

    private val uid get() = Uid(auth.currentUser?.uid!!)

    protected fun getOnAuthCompletedListener(request: Query) =
        OnCompleteListener<AuthResult> { task ->
            if (task.isSuccessful) {
                val response = Query(data = uid, callback = request.callback)
                authOnCompletedAction.onSucceed(response)
            } else {
                authOnCompletedAction.onFailure(request = request, exceptionMessage = task.exception?.message)
            }
        }

    override fun auth(request: Query) {
        val listener = getOnAuthCompletedListener(request)
        val (login, password) = request.data as LoginDataDto

        auth.signInWithEmailAndPassword(login, password)
            .addOnCompleteListener(listener)
    }
}