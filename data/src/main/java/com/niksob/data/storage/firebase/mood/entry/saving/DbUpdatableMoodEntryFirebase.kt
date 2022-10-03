package com.niksob.data.storage.firebase.mood.entry.saving

import com.niksob.data.provider.DbFirebaseRefProvider
import com.niksob.domain.data.dto.MoodEntryDto
import com.niksob.domain.data.dto.MoodEntryForSaveDto
import com.niksob.domain.model.*
import com.niksob.data.model.DbFirebaseMoodEntryKey.DEGREE
import com.niksob.data.model.DbFirebaseMoodEntryKey.TIME
import com.niksob.data.model.DbFirebaseMoodEntryKey.TAG_IDS
import com.niksob.data.storage.firebase.base.loader.FirebaseLoader
import com.niksob.data.storage.firebase.base.saver.FirebaseSaver
import com.niksob.data.storage.firebase.mood.entry.loading.LoadableDbMoodEntryFirebase
import com.niksob.data.storage.mood.entry.saving.UpdatableMoodEntryStorage

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
            DEGREE.key to moodEntryDto.degree,
            TIME.key to moodEntryDto.time,
            TAG_IDS.key to moodEntryDto.tagIds,
        )

    override fun save(request: Query) {
        val moodEntryForSaveDto = request.data as MoodEntryForSaveDto
        uid = moodEntryForSaveDto.uid
        moodEntryDto = moodEntryForSaveDto.data

        saver.save(task = firebaseQuery, callback = request.callback!!)
    }
}