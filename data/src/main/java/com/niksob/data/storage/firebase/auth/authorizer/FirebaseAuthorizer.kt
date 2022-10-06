package com.niksob.data.storage.firebase.auth.authorizer

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.niksob.data.provider.AuthProvider
import com.niksob.data.storage.auth.authorizer.Authorizer
import com.niksob.data.storage.firebase.auth.authorizer.data_loaded_action.AuthorizerOnCompletedAction
import com.niksob.domain.data.dto.LoginDataDto
import com.niksob.domain.model.Query

open class FirebaseAuthorizer(
    authProvider: AuthProvider,
    private val authOnCompletedAction: AuthorizerOnCompletedAction,
) : Authorizer {

    protected val auth: FirebaseAuth = authProvider.auth

    protected fun getOnAuthCompletedListener(request: Query) =
        OnCompleteListener<AuthResult> { task ->
            if (task.isSuccessful) {
                authOnCompletedAction.onSucceed(request)
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