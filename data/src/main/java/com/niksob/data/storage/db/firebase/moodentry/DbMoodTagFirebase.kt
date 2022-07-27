package com.niksob.data.storage.db.firebase.moodentry

import com.google.android.gms.tasks.Task
import com.niksob.data.provider.DbProvider
import com.niksob.data.storage.db.MoodTagStorage
import com.niksob.data.storage.provider.AppStringStorage
import com.niksob.domain.model.Callback
import com.niksob.domain.data.dto.MoodTagDataDto
import com.niksob.domain.model.Query

private const val MOOD_TAGS_DB_REF_NAME = "mood_tags"

private const val SUCCESS_SAVING_REASON_STR_ID = "success_saving"
private const val FAILURE_SAVING_REASON_STR_ID = "failure_saving"
private const val EXCEPTION_MESSAGE_PREFIX = ". Exception message: "
private const val SUCCESS_STATUS = true

class DbMoodTagFirebase(
    dbProvider: DbProvider,
    private val moodTagsEventProvider: MoodTagsValueEventFirebaseProvider,
    private val stringStorage: AppStringStorage,
) : MoodTagStorage {

    private val moodTagDbProvider = dbProvider.getDbReference()
        .child(MOOD_TAGS_DB_REF_NAME)

    override fun loadByUserIdAndDate(request: Query) {

        val tagsDataDto = request.data as MoodTagDataDto

        moodTagDbProvider.child(tagsDataDto.uid.data)
            .addListenerForSingleValueEvent(moodTagsEventProvider.getListener(tagsDataDto, request.callback!!))
    }

    @Suppress("UNCHECKED_CAST")
    override fun save(request: Query) {
        val tagsDto = request.data as Map<String, Any>
        moodTagDbProvider.updateChildren(tagsDto)
            .addOnCompleteListener { task -> onMoodEntrySavingComplete(task, request.callback!!) }
    }

    private fun onMoodEntrySavingComplete(task: Task<Void>, callback: Callback<Query>) {

        val entryResponse =
            if (task.isSuccessful)
                Query(completed = SUCCESS_STATUS, reason = successSaveReason())
            else
                Query(reason = failureSaveReason(task.exception?.message))
        callback.call(entryResponse)
    }

    private fun successSaveReason() = stringStorage.getString(SUCCESS_SAVING_REASON_STR_ID)

    private fun failureSaveReason(failureMessage: String?) =
        stringStorage.getString(FAILURE_SAVING_REASON_STR_ID) + failureMessage.let { EXCEPTION_MESSAGE_PREFIX + it }
}