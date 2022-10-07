package com.niksob.data.storage.firebase.auth.authorizer.data_loaded_action

import com.niksob.data.base.OnCompletedAction
import com.niksob.data.storage.firebase.auth.authorizer.reason.AuthorizerResponseReasonProvider
import com.niksob.domain.model.Query

open class AuthOnCompletedAction(
    private val reasonProvider: AuthorizerResponseReasonProvider,
) : OnCompletedAction {

    override fun onSucceed(request: Query) {
        val response = Query(
            data = request.data,
            completed = true,
            reason = reasonProvider.successfulReason
        )
        val callback = request.callback
        callback?.call?.invoke(response)
    }

    override fun onFailure(request: Query, exceptionMessage: String?) {
        val response = Query(
            completed = false,
            reason = reasonProvider.failureReason(exceptionMessage)
        )
        val callback = request.callback
        callback?.call?.invoke(response)
    }
}