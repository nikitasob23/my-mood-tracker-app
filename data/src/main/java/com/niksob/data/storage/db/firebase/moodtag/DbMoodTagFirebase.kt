package com.niksob.data.storage.db.firebase.moodtag

import com.niksob.data.provider.DbProvider
import com.niksob.data.provider.ResponseReasonProvider
import com.niksob.data.storage.db.MoodTagStorage
import com.niksob.data.storage.db.firebase.SaveCompletionAction
import com.niksob.domain.data.dto.MoodTagDataDto
import com.niksob.domain.model.Query

private const val MOOD_TAGS_DB_REF_NAME = "mood_tags"

class DbMoodTagFirebase(
    dbProvider: DbProvider,
    saveReasonProvider: ResponseReasonProvider,
    private val moodTagsEventProvider: MoodTagsValueEventFirebaseProvider,
) : MoodTagStorage, SaveCompletionAction(saveReasonProvider) {

    private val moodTagDbProvider = dbProvider.getDbReference()
        .child(MOOD_TAGS_DB_REF_NAME)

    override fun loadByUserIdAndDate(request: Query) {

        val tagsDataDto = request.data as MoodTagDataDto

        val moodTagsEventListener = moodTagsEventProvider.getListener(tagsDataDto, request.callback!!)

        moodTagDbProvider.child(tagsDataDto.uid.data)
            .addListenerForSingleValueEvent(moodTagsEventListener)
    }

    @Suppress("UNCHECKED_CAST")
    override fun save(request: Query) {
        val tagsDto = request.data as Map<String, Any>
        moodTagDbProvider.updateChildren(tagsDto)
            .addOnCompleteListener { task -> onComplete(task, request.callback!!) }
    }
}