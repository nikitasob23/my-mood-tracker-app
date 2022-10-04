package com.niksob.data.storage.firebase.user.reason

import com.niksob.data.model.user.UserResponseReason.FAILED_USER_ADDITION
import com.niksob.data.model.user.UserResponseReason.SUCCESS_USER_ADDITION
import com.niksob.data.storage.firebase.base.reason.BaseResponseReasonProvider
import com.niksob.data.storage.provider.AppStringStorage

open class UserSaveResponseReasonProvider(
    protected val stringStorage: AppStringStorage,
) : BaseResponseReasonProvider(stringStorage) {

    override val successReasonId get() = SUCCESS_USER_ADDITION.value

    override val failureReasonId get() = FAILED_USER_ADDITION.value
}