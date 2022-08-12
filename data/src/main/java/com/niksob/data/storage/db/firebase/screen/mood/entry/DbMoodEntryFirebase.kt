package com.niksob.data.storage.db.firebase.screen.mood.entry

import com.niksob.data.provider.DbFirebaseRefProvider
import com.niksob.data.storage.db.MoodEntryStorage
import com.niksob.data.storage.db.firebase.loader.FirebaseLoader
import com.niksob.data.storage.db.firebase.saver.FirebaseSaver
import com.niksob.data.storage.db.firebase.screen.mood.entry.loading.LoadableDbMoodEntryFirebase
import com.niksob.domain.data.dto.MoodEntryForSaveDto
import com.niksob.domain.model.*

private const val DEGREE_KEY = "degree"
private const val TIME_KEY = "time"
private const val TAG_IDS_KEY = "tagIds"

class DbMoodEntryFirebase(
    private val moodEntryDbProvider: DbFirebaseRefProvider,
    private val saver: FirebaseSaver,
    loader: FirebaseLoader,
) : MoodEntryStorage, LoadableDbMoodEntryFirebase(moodEntryDbProvider, loader) {

    private lateinit var moodEntryForSaveDto: MoodEntryForSaveDto

    private val firebaseQuery
        get() = moodEntryDbProvider.ref
            .updateChildren(getUpdateChildrenMap())

    private fun getUpdateChildrenMap(): Map<String, Any> {

        val (uid, entryDto) = moodEntryForSaveDto

        return mapOf(
            uid.data to mapOf(
                entryDto.date to mapOf(
                    entryDto.id.data to mapOf(
                        DEGREE_KEY to entryDto.degree,
                        TIME_KEY to entryDto.time,
                        TAG_IDS_KEY to entryDto.tagIds,
                    )
                )
            )
        )
    }

    override fun save(request: Query) {

        moodEntryForSaveDto = request.data as MoodEntryForSaveDto
        saver.save(firebaseQuery, request.callback!!)
    }
}