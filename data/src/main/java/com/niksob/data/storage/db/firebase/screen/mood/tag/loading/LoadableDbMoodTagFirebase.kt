package com.niksob.data.storage.db.firebase.screen.mood.tag.loading

import com.niksob.data.provider.DbProvider
import com.niksob.data.storage.db.LoadableMoodTagStorage
import com.niksob.data.storage.db.firebase.loader.FirebaseLoader
import com.niksob.domain.data.dto.MoodTagDataDto
import com.niksob.domain.model.Query

open class LoadableDbMoodTagFirebase(
    private val moodTagDbProvider: DbProvider,
    private val loader: FirebaseLoader,
) : LoadableMoodTagStorage {

    private lateinit var tagsDataDto: MoodTagDataDto

    private val firebaseQuery
        get() = moodTagDbProvider.dbReference
            .child(tagsDataDto.uid.data)
            .ref

    override fun loadByUserIdAndDate(request: Query) {

        tagsDataDto = request.data as MoodTagDataDto
        loader.load(request, firebaseQuery)
    }
}