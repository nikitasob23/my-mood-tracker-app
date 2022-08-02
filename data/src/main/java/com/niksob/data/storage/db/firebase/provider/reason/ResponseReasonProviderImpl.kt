package com.niksob.data.storage.db.firebase.provider.reason

import com.niksob.data.provider.ResponseReasonProvider
import com.niksob.data.storage.provider.AppStringStorage

private const val SUCCESS_STATUS = true
private const val EXCEPTION_MESSAGE_PREFIX = ". Exception message: "

abstract class ResponseReasonProviderImpl(
    private val stringStorage: AppStringStorage,
) : ResponseReasonProvider {

    override val successStatus = SUCCESS_STATUS

    protected abstract val successReasonId: String

    protected abstract val failureReasonId: String

    override val successfulReason get() = stringStorage.getString(successReasonId)

    override fun failureReason(failureMessage: String?) =
        stringStorage.getString(failureReasonId) +
                failureMessage.let { EXCEPTION_MESSAGE_PREFIX + it }
}