package com.niksob.data.storage.db.firebase.moodentry

import com.niksob.data.provider.DbProvider
import com.niksob.data.storage.db.MoodTagStorage
import com.niksob.domain.model.MoodTagDataDto
import com.niksob.domain.model.Query

private const val MOOD_TAGS_DB_REF_NAME = "mood_tags"

class DbMoodTagFirebase(
    dbProvider: DbProvider,
    private val moodTagsEventProvider: MoodTagsValueEventFirebaseProvider,
) : MoodTagStorage {

    private val moodTagDbProvider = dbProvider.getDbReference()
        .child(MOOD_TAGS_DB_REF_NAME)

    override fun loadByUserIdAndDate(request: Query) {

        val tagsDataDto = request.data as MoodTagDataDto

        moodTagDbProvider.child(tagsDataDto.uid)
            .addListenerForSingleValueEvent(moodTagsEventProvider.getListener(tagsDataDto, request.callback!!))
    }

    override fun save(request: Query) {
        TODO("Not yet implemented")
    }
}