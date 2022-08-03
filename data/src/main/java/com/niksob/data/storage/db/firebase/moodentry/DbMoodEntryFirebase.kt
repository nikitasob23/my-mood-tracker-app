package com.niksob.data.storage.db.firebase.moodentry

import com.google.firebase.database.DatabaseReference
import com.niksob.data.provider.DbProvider
import com.niksob.data.provider.ResponseReasonProvider
import com.niksob.data.storage.db.MoodEntryStorage
import com.niksob.data.storage.db.firebase.SaveCompletionAction
import com.niksob.domain.data.dto.MoodEntriesDataDto
import com.niksob.domain.data.dto.MoodEntryForSaveDto
import com.niksob.domain.model.*

private const val MOOD_ENTRIES_DB_REF_NAME = "mood_entries"

private const val DEGREE_KEY = "degree"
private const val TIME_KEY = "time"
private const val TAG_IDS_KEY = "tagIds"

class DbMoodEntryFirebase(
    private val dbProvider: DbProvider,
    private val moodEntriesValueEventProvider: MoodEntriesValueEventFirebaseProvider,
    saveReasonProvider: ResponseReasonProvider,
) : MoodEntryStorage, SaveCompletionAction(saveReasonProvider) {

    override fun loadByUserIdAndDate(requestDto: Query) {

        val requestDtoData = requestDto.data as MoodEntriesDataDto

        val moodEntriesValueEventListener = moodEntriesValueEventProvider.getListener(requestDto.callback!!)

        dbProvider.getDbReference()
            .child(MOOD_ENTRIES_DB_REF_NAME)
            .child(requestDtoData.uid.data)
            .orderByKey()
            .startAt(requestDtoData.startDate)
            .endAt(requestDtoData.endDate)
            .addListenerForSingleValueEvent(moodEntriesValueEventListener)
    }

    override fun save(request: Query) {

        val (uid, entryDto) = request.data as MoodEntryForSaveDto

        val entryRef = dbProvider.getDbReference()
            .child(MOOD_ENTRIES_DB_REF_NAME)
            .child(uid.data)
            .child(entryDto.date)
            .child(entryDto.id.data)

        val callback = request.callback!!

        setValueToDbRef(entryRef, DEGREE_KEY, entryDto.degree, callback)
        setValueToDbRef(entryRef, TIME_KEY, entryDto.time, callback)
        setValueToDbRef(entryRef, TAG_IDS_KEY, entryDto, callback)
    }

    private fun setValueToDbRef(ref: DatabaseReference, key: String, value: Any, callback: Callback<Query>) {
        ref.child(key)
            .setValue(value)
            .addOnCompleteListener { task -> onComplete(task, callback)}
    }
}