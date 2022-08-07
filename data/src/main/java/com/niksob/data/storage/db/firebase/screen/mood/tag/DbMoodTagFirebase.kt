package com.niksob.data.storage.db.firebase.screen.mood.tag

import com.niksob.data.provider.DbProvider
import com.niksob.data.storage.db.MoodTagStorage
import com.niksob.data.storage.db.firebase.loader.FirebaseLoader
import com.niksob.data.storage.db.firebase.saver.FirebaseSaver
import com.niksob.domain.data.dto.MoodTagDataDto
import com.niksob.domain.model.Query

private const val MOOD_TAGS_DB_REF_NAME = "mood_tags"

class DbMoodTagFirebase(
    dbProvider: DbProvider,
    private val loader: FirebaseLoader,
    private val saver: FirebaseSaver,
) : MoodTagStorage {

    private val moodTagDbProvider = dbProvider.getDbReference()
        .child(MOOD_TAGS_DB_REF_NAME)

    override fun loadByUserIdAndDate(request: Query) {

        val tagsDataDto = request.data as MoodTagDataDto

        val firebaseQuery = moodTagDbProvider.child(tagsDataDto.uid.data).ref
        loader.load(request, firebaseQuery)
    }

    @Suppress("UNCHECKED_CAST")
    override fun save(request: Query) {
        val tagsDto = request.data as Map<String, Any>

        val firebaseTask = moodTagDbProvider.updateChildren(tagsDto)
        saver.save(firebaseTask, request.callback!!)
    }
}