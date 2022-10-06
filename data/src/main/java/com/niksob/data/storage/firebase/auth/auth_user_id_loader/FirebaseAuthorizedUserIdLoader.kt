package com.niksob.data.storage.firebase.auth.auth_user_id_loader

import com.niksob.data.provider.AuthProvider
import com.niksob.data.storage.auth.auth_user_id_loader.AuthorizedUserIdLoader
import com.niksob.data.storage.firebase.auth.auth_user_id_loader.data_loaded_action.AuthUserIdOnCompletedAction
import com.niksob.data.storage.firebase.auth.signout.FirebaseSignOutMaker
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query
import com.niksob.domain.model.Uid

open class FirebaseAuthorizedUserIdLoader(
    authProvider: AuthProvider,
    private val authUserIdOnCompletedAction: AuthUserIdOnCompletedAction,
) : AuthorizedUserIdLoader, FirebaseSignOutMaker(authProvider, authUserIdOnCompletedAction) {

    override fun loadAuthorizeUserId(callback: Callback<Query>) {

        if (!userIsLoginIn()) {
            val request = Query(callback = callback)
            authUserIdOnCompletedAction.onFailure(request)
            return
        }
        val request = Query(data = Uid(auth.currentUser!!.uid), callback = callback)
        authUserIdOnCompletedAction.onSucceed(request)
    }

    private fun userIsLoginIn() = auth.currentUser != null
}