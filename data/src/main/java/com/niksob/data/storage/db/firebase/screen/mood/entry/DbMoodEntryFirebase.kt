package com.niksob.data.storage.db.firebase.screen.mood.entry

import com.niksob.data.provider.DbProvider
import com.niksob.data.storage.db.MoodEntryStorage
import com.niksob.data.storage.db.firebase.loader.FirebaseLoader
import com.niksob.data.storage.db.firebase.saver.FirebaseSaver
import com.niksob.domain.data.dto.MoodEntriesDataDto
import com.niksob.domain.data.dto.MoodEntryForSaveDto
import com.niksob.domain.model.*

private const val MOOD_ENTRIES_DB_REF_NAME = "mood_entries"

private const val DEGREE_KEY = "degree"
private const val TIME_KEY = "time"
private const val TAG_IDS_KEY = "tagIds"

class DbMoodEntryFirebase(
    dbProvider: DbProvider,
    private val loader: FirebaseLoader,
    private val saver: FirebaseSaver,
) : MoodEntryStorage {

    private val moodEntryDbProvider = dbProvider.getDbReference()
        .child(MOOD_ENTRIES_DB_REF_NAME)

    override fun loadByUserIdAndDate(requestDto: Query) {

        val requestDtoData = requestDto.data as MoodEntriesDataDto

        val firebaseQuery = moodEntryDbProvider
            .child(requestDtoData.uid.data)
            .orderByKey()
            .startAt(requestDtoData.startDate)
            .endAt(requestDtoData.endDate)

        loader.load(requestDto, firebaseQuery)
    }

    override fun save(request: Query) {

        val (uid, entryDto) = request.data as MoodEntryForSaveDto

        val updateChildrenMap = mapOf(
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

        val firebaseQuery = moodEntryDbProvider.updateChildren(updateChildrenMap)

        saver.save(firebaseQuery, request.callback!!)
    }
}