package com.niksob.data.storage.db.firebase.moodentry

import com.niksob.data.storage.provider.AppStringStorage

private const val SUCCESS_SAVING_REASON_STR_ID = "success_saving"
private const val FAILURE_SAVING_REASON_STR_ID = "failure_saving"

class MoodEntrySaveResponseReasonProvider(
    stringStorage: AppStringStorage,
) : ResponseReasonProviderImpl(stringStorage) {

    override val successReasonId = SUCCESS_SAVING_REASON_STR_ID

    override val failureReasonId = FAILURE_SAVING_REASON_STR_ID
}