package com.niksob.data.storage.db.firebase.screen.mood.tag.loading

import com.niksob.data.storage.db.firebase.response.reason.ResponseReasonProviderImpl
import com.niksob.data.storage.provider.AppStringStorage

private const val SUCCESS_LOAD_TAGS_REASON_STR_ID = "mood_tags_was_load"
private const val FAILURE_LOAD_TAGS_REASON_STR_ID = "mood_tags_was_not_load"

class MoodTagLoadResponseReasonProvider(
    stringStorage: AppStringStorage,
) : ResponseReasonProviderImpl(stringStorage) {

    override val successReasonId = SUCCESS_LOAD_TAGS_REASON_STR_ID

    override val failureReasonId = FAILURE_LOAD_TAGS_REASON_STR_ID
}