package com.niksob.data.storage.firebase.auth.signout.response

import com.niksob.data.model.ResponseReasonName
import com.niksob.data.storage.firebase.auth.authorizer.reason.AuthorizerResponseReasonProvider
import com.niksob.data.storage.provider.AppStringStorage

open class SignOutResponseReasonProvider(
    stringStorage: AppStringStorage,
) : AuthorizerResponseReasonProvider(stringStorage) {

    override val successReasonId get() = ResponseReasonName.SUCCESS_SIGN_OUT_REASON.value

    override val failureReasonId get() = ResponseReasonName.FAILED_SIGN_OUT_REASON.value
}