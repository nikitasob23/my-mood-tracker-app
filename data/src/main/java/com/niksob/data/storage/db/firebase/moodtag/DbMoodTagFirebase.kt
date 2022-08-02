package com.niksob.data.storage.db.firebase.moodtag

import com.google.android.gms.tasks.Task
import com.niksob.data.provider.DbProvider
import com.niksob.data.provider.ResponseReasonProvider
import com.niksob.data.storage.db.MoodTagStorage
import com.niksob.domain.model.Callback
import com.niksob.domain.data.dto.MoodTagDataDto
import com.niksob.domain.model.Query

private const val MOOD_TAGS_DB_REF_NAME = "mood_tags"

class DbMoodTagFirebase(
    dbProvider: DbProvider,
    private val moodTagsEventProvider: MoodTagsValueEventFirebaseProvider,
    private val saveReasonProvider: ResponseReasonProvider,
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
                Query(completed = saveReasonProvider.successStatus, reason = saveReasonProvider.successfulReason)
            else
                Query(reason = saveReasonProvider.failureReason(task.exception?.message))
        callback.call(entryResponse)
    }
}