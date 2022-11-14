package com.niksob.data.storage.firebase.mood_tag.saving.reason

import com.niksob.data.storage.firebase.base.reason.BaseResponseReasonProvider
import com.niksob.data.storage.provider.AppStringStorage

private const val SUCCESS_SAVING_TAGS_REASON_STR_ID = "success_saving"
private const val FAILURE_SAVING_TAGS_REASON_STR_ID = "failure_saving"

class MoodTagSaveResponseReasonProvider(
    stringStorage: AppStringStorage,
) : BaseResponseReasonProvider(stringStorage) {

    override val successReasonId = SUCCESS_SAVING_TAGS_REASON_STR_ID

    override val failureReasonId = FAILURE_SAVING_TAGS_REASON_STR_ID
}