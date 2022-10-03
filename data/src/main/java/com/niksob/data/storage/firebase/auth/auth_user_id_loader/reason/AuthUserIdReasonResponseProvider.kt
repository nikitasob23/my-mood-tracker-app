package com.niksob.data.storage.firebase.auth.auth_user_id_loader.reason

import com.niksob.data.model.ResponseReasonName
import com.niksob.data.storage.firebase.auth.signout.response.SignOutResponseReasonProvider
import com.niksob.data.storage.provider.AppStringStorage

class AuthUserIdReasonResponseProvider(
    stringStorage: AppStringStorage,
) : SignOutResponseReasonProvider(stringStorage) {

    override val successReasonId get() = ResponseReasonName.SUCCESS_AUTH_USER_ID_LOAD.value

    override val failureReasonId get() = ResponseReasonName.FAILURE_AUTH_USER_ID_LOAD.value
}
