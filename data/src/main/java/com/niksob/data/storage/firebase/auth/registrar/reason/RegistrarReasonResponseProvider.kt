package com.niksob.data.storage.firebase.auth.registrar.reason

import com.niksob.data.model.ResponseReasonName.SUCCESS_REGISTER_REASON
import com.niksob.data.model.ResponseReasonName.FAILED_REGISTER_REASON
import com.niksob.data.storage.firebase.auth.auth_user_id_loader.reason.AuthUserIdReasonResponseProvider
import com.niksob.data.storage.provider.AppStringStorage

class RegistrarReasonResponseProvider(
    stringStorage: AppStringStorage,
) : AuthUserIdReasonResponseProvider(stringStorage) {

    override val successReasonId get() = SUCCESS_REGISTER_REASON.value

    override val failureReasonId get() = FAILED_REGISTER_REASON.value
}
