package com.niksob.data.storage.firebase.auth.signout

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.niksob.data.base.OnCompletedAction
import com.niksob.data.provider.AuthProvider
import com.niksob.data.storage.auth.signout.SignOutMaker
import com.niksob.data.storage.firebase.auth.authorizer.FirebaseAuthorizer
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query

open class FirebaseSignOutMaker(
    authProvider: AuthProvider,
    authOnCompletedAction: OnCompletedAction,
) : SignOutMaker, FirebaseAuthorizer(authProvider, authOnCompletedAction) {

    override fun signOut(callback: Callback<Query>) {
        val listener = getAuthStateListener(callback)
        auth.addAuthStateListener(listener)
        auth.signOut()
    }

    private fun getAuthStateListener(callback: Callback<Query>) =
        object : AuthStateListener {
            override fun onAuthStateChanged(firebaseAuth: FirebaseAuth) {
                auth.removeAuthStateListener(this)

                changeAuthState(firebaseAuth, callback)
            }
        }

    private fun changeAuthState(firebaseAuth: FirebaseAuth, callback: Callback<Query>) {
        val request = Query(
            data = firebaseAuth.currentUser,
            callback = callback,
        )
        if (!isSucceedSignOut(firebaseAuth)) {
            authOnCompletedAction.onFailure(request)
            return
        }
        authOnCompletedAction.onSucceed(request)
    }

    private fun isSucceedSignOut(firebaseAuth: FirebaseAuth) = firebaseAuth.currentUser == null
}