package com.niksob.data.storage.db.firebase.moodentry

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.niksob.data.provider.DbProvider
import com.niksob.data.storage.db.MoodEntryStorage
import com.niksob.data.storage.provider.AppStringStorage
import com.niksob.domain.data.dto.MoodEntriesDataDto
import com.niksob.domain.data.dto.MoodEntriesDto
import com.niksob.domain.data.dto.MoodEntryDto
import com.niksob.domain.data.dto.MoodEntryForSaveDto
import com.niksob.domain.model.*

private const val MOOD_ENTRIES_DB_REF_NAME = "mood_entries"

private const val SUCCESS_LOAD_REASON_STR_ID = "mood_entries_was_load"
private const val FAILURE_LOAD_REASON_STR_ID = "mood_entries_was_not_load"
private const val SUCCESS_SAVING_REASON_STR_ID = "success_saving"
private const val FAILURE_SAVING_REASON_STR_ID = "failure_saving"
private const val EXCEPTION_MESSAGE_PREFIX = ". Exception message: "
private const val SUCCESS_STATUS = true

private const val DEGREE_KEY = "degree"
private const val TIME_KEY = "time"
private const val TAG_IDS_KEY = "tagIds"

class DbMoodEntryFirebase(
    private val dbProvider: DbProvider,
    private val stringStorage: AppStringStorage,
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
                    completed = SUCCESS_STATUS,
                    reason = successLoadReason()
                )
                callback.call(response)
            }

            override fun onCancelled(error: DatabaseError) {

                val response = Query(
                    reason = failureLoadReason(error.message)
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
                Query(completed = SUCCESS_STATUS, reason = successSaveReason())
            else
                Query(reason = failureSaveReason(task.exception?.message))
        callback.call(entryResponse)
    }

    private fun successSaveReason() = stringStorage.getString(SUCCESS_SAVING_REASON_STR_ID)

    private fun successLoadReason() = stringStorage.getString(SUCCESS_LOAD_REASON_STR_ID)

    private fun failureSaveReason(failureMessage: String?) =
        stringStorage.getString(FAILURE_SAVING_REASON_STR_ID) + failureMessage.let { EXCEPTION_MESSAGE_PREFIX + it }

    private fun failureLoadReason(failureMessage: String?) =
        stringStorage.getString(FAILURE_LOAD_REASON_STR_ID) + failureMessage.let { EXCEPTION_MESSAGE_PREFIX + it }
}