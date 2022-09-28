package com.niksob.data.storage.db.firebase.screen.mood.entry

import com.niksob.data.provider.DbFirebaseRefProvider
import com.niksob.data.storage.db.UpdatableMoodEntryStorage
import com.niksob.data.storage.db.firebase.loader.FirebaseLoader
import com.niksob.data.storage.db.firebase.saver.FirebaseSaver
import com.niksob.data.storage.db.firebase.screen.mood.entry.loading.LoadableDbMoodEntryFirebase
import com.niksob.domain.data.dto.MoodEntryDto
import com.niksob.domain.data.dto.MoodEntryForSaveDto
import com.niksob.domain.model.*

private const val DEGREE_KEY = "degree"
private const val TIME_KEY = "time"
private const val TAG_IDS_KEY = "tagIds"

open class DbUpdatableMoodEntryFirebase(
    private val moodEntryDbProvider: DbFirebaseRefProvider,
    private val saver: FirebaseSaver,
    loader: FirebaseLoader,
) : UpdatableMoodEntryStorage, LoadableDbMoodEntryFirebase(moodEntryDbProvider, loader) {

    protected var uid: Uid? = null

    protected lateinit var moodEntryDto: MoodEntryDto

    protected val firebaseQuery
        get() = moodEntryDbProvider.ref
            .updateChildren(moodEntryMap)

    private val moodEntryMap get() = userIdToEntryDateAndDataMap

    private val userIdToEntryDateAndDataMap
        get() = mapOf(
            uid!!.data to dateToEntryIdAndDataMap
        )

    private val dateToEntryIdAndDataMap
        get() = mapOf(
            moodEntryDto.date to idToEntryMap
        )

    private val idToEntryMap
        get() = mapOf(
            moodEntryDto.id.data to entryMap
        )

    private val entryMap
        get() = mapOf(
            DEGREE_KEY to moodEntryDto.degree,
            TIME_KEY to moodEntryDto.time,
            TAG_IDS_KEY to moodEntryDto.tagIds,
        )

    override fun save(request: Query) {
        val moodEntryForSaveDto = request.data as MoodEntryForSaveDto
        uid = moodEntryForSaveDto.uid
        moodEntryDto = moodEntryForSaveDto.data

        saver.save(task = firebaseQuery, callback = request.callback!!)
    }
}