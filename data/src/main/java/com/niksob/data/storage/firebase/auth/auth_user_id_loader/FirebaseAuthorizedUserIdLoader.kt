package com.niksob.data.storage.firebase.auth.auth_user_id_loader

import com.niksob.data.base.OnCompletedAction
import com.niksob.data.provider.AuthProvider
import com.niksob.data.storage.base.auth.auth_user_id_loader.AuthorizedUserIdLoader
import com.niksob.data.storage.firebase.auth.signout.FirebaseSignOutMaker
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query
import com.niksob.domain.model.Uid

open class FirebaseAuthorizedUserIdLoader(
    authProvider: AuthProvider,
    authOnCompletedAction: OnCompletedAction,
) : AuthorizedUserIdLoader, FirebaseSignOutMaker(authProvider, authOnCompletedAction) {

    override fun loadAuthorizeUserId(callback: Callback<Query>) {

        if (!userIsLoginIn()) {
            val request = Query(callback = callback)
            authOnCompletedAction.onFailure(request)
            return
        }
        val request = Query(data = Uid(auth.currentUser!!.uid), callback = callback)
        authOnCompletedAction.onSucceed(request)
    }

    private fun userIsLoginIn() = auth.currentUser != null
}