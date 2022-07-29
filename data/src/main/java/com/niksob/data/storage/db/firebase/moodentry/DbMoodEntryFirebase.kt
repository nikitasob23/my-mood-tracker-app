package com.niksob.data.storage.db.firebase.moodentry

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.niksob.data.provider.DbProvider
import com.niksob.data.storage.db.MoodEntryStorage
import com.niksob.domain.data.dto.MoodEntriesDataDto
import com.niksob.domain.data.dto.MoodEntriesDto
import com.niksob.domain.data.dto.MoodEntryDto
import com.niksob.domain.data.dto.MoodEntryForSaveDto
import com.niksob.domain.model.*

private const val MOOD_ENTRIES_DB_REF_NAME = "mood_entries"

private const val DEGREE_KEY = "degree"
private const val TIME_KEY = "time"
private const val TAG_IDS_KEY = "tagIds"

class DbMoodEntryFirebase(
    private val dbProvider: DbProvider,
    private val loadReasonProvider: ResponseReasonProvider,
    private val saveReasonProvider: ResponseReasonProvider,
) : MoodEntryStorage {

    private lateinit var callback: Callback<Query>

    @Suppress("UNCHECKED_CAST")
    private val moodEntriesEventListener
        get() = object : ValueEventListener {
            override fun onDataChange(userIdSnapshot: DataSnapshot) {

                val loadedMoodEntries = userIdSnapshot.children.map { dateSnapshot ->
                    dateSnapshot.children.map { idSnapshot ->
                        MoodEntryDto(
                            id = MoodEntryId(idSnapshot.key!!),
                            date = dateSnapshot.key!!,
                            degree = idSnapshot.child(DEGREE_KEY)
                                .getValue(Int::class.java)!!,
                            time = idSnapshot.child(TIME_KEY)
                                .getValue(String::class.java)!!,
                            tagIds = idSnapshot.child(TAG_IDS_KEY).children
                                .map { tagIdSnapshot -> MoodTagId(tagIdSnapshot.key!!) },
                        )
                    }
                }.flatten()

                val response = Query(
                    data = MoodEntriesDto(uid = Uid(userIdSnapshot.key!!), data = loadedMoodEntries),
                    completed = loadReasonProvider.successStatus,
                    reason = loadReasonProvider.successfulReason
                )
                callback.call(response)
            }

            override fun onCancelled(error: DatabaseError) {

                val response = Query(
                    reason = loadReasonProvider.failureReason(error.message)
                )
                callback.call(response)
            }
        }

    override fun loadByUserIdAndDate(requestDto: Query) {

        callback = requestDto.callback!!
        val requestDtoData = requestDto.data!! as MoodEntriesDataDto

        dbProvider.getDbReference()
            .child(MOOD_ENTRIES_DB_REF_NAME)
            .child(requestDtoData.uid.data)
            .orderByKey()
            .startAt(requestDtoData.startDate)
            .endAt(requestDtoData.endDate)
            .addListenerForSingleValueEvent(moodEntriesEventListener)
    }

    override fun save(request: Query) {

        callback = request.callback!!
        val (uid, entryDto) = request.data as MoodEntryForSaveDto

        val entryRef = dbProvider.getDbReference()
            .child(MOOD_ENTRIES_DB_REF_NAME)
            .child(uid.data)
            .child(entryDto.date)
            .child(entryDto.id.data)

        setValueToDbRef(entryRef, DEGREE_KEY, entryDto.degree)
        setValueToDbRef(entryRef, TIME_KEY, entryDto.time)
        setValueToDbRef(entryRef, TAG_IDS_KEY, entryDto)
    }

    private fun setValueToDbRef(ref: DatabaseReference, key: String, value: Any) {
        ref.child(key)
            .setValue(value)
            .addOnCompleteListener(moodEntryCompleteListener)
    }

    private val moodEntryCompleteListener = OnCompleteListener<Void> { task ->

        val entryResponse =
            if (task.isSuccessful)
                Query(completed = saveReasonProvider.successStatus, reason = saveReasonProvider.successfulReason)
            else
                Query(reason = saveReasonProvider.failureReason(task.exception?.message))
        callback.call(entryResponse)
    }
}