package com.niksob.data.storage.firebase.auth.signout

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.niksob.data.provider.AuthProvider
import com.niksob.data.storage.auth.signout.SignOut
import com.niksob.data.storage.firebase.auth.authorizer.FirebaseAuthorizer
import com.niksob.data.storage.firebase.auth.signout.data_loaded_action.SignOutOnCompletedAction
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query

open class FirebaseSignOut(
    authProvider: AuthProvider,
    signOutOnCompletedAction: SignOutOnCompletedAction,
) : SignOut, FirebaseAuthorizer(authProvider, signOutOnCompletedAction) {

    override fun signOut(callback: Callback<Query>) {
        val listener = getAuthStateListener(callback)
        auth.addAuthStateListener(listener)
        auth.signOut()
    }

    private fun getAuthStateListener(callback: Callback<Query>) =
        object : AuthStateListener {
            override fun onAuthStateChanged(firebaseAuth: FirebaseAuth) {
                auth.removeAuthStateListener(this)

                checkAuthState(firebaseAuth, callback)
            }
        }

    private fun checkAuthState(firebaseAuth: FirebaseAuth, callback: Callback<Query>) {
        val request = Query(
            data = firebaseAuth.currentUser,
            callback = callback,
        )
        if (!isSucceedSignOut(firebaseAuth)) {
            authorizerOnCompletedAction.onFailure(request)
            return
        }
        authorizerOnCompletedAction.onSucceed(request)
    }

    private fun isSucceedSignOut(firebaseAuth: FirebaseAuth) = firebaseAuth.currentUser == null
}