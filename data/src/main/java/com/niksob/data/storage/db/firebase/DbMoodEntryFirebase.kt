package com.niksob.data.storage.db.firebase

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.niksob.data.provider.DbProvider
import com.niksob.data.storage.db.MoodEntryStorage
import com.niksob.data.storage.provider.AppStringStorage
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query
import com.niksob.domain.data.dto.MoodEntriesDataDto

const val MOOD_ENTRIES_DB_REF_NAME = "mood_entries"

private const val SUCCESS_LOAD_REASON_STR_ID = "mood_entry_was_load"
private const val FAILURE_LOAD_REASON_STR_ID = "mood_entry_was_not_load"
private const val SUCCESS_SAVING_REASON_STR_ID = "success_saving"
private const val FAILURE_SAVING_REASON_STR_ID = "failure_saving"

class DbMoodEntryFirebase(
    private val dbProvider: DbProvider,
    private val stringStorage: AppStringStorage,
) : MoodEntryStorage {

    private lateinit var dbFirebaseQuery: com.google.firebase.database.Query

    private lateinit var moodEntriesEventListener: ValueEventListener

    override fun loadByUserIdAndDate(requestDto: Query) {
        val requestDtoData = requestDto.data!! as MoodEntriesDataDto

        dbFirebaseQuery = dbProvider.getDbReference()
            .child(MOOD_ENTRIES_DB_REF_NAME)
            .child(requestDtoData.uid)
            .orderByKey()
            .startAt(requestDtoData.startDate)
            .limitToFirst(requestDtoData.dayLimit)

        moodEntriesEventListener = getMoodEntriesEventListener(requestDto.callback!!)

        dbFirebaseQuery.addValueEventListener(moodEntriesEventListener)
    }

    override fun save(request: Query) {
        TODO("Not yet implemented")
    }

    @Suppress("UNCHECKED_CAST")
    private fun getMoodEntriesEventListener(callback: Callback<Query>) =
        object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dbFirebaseQuery.removeEventListener(moodEntriesEventListener)

                val resultMap = HashMap<String, Any>()

                snapshot.children.forEach { result ->
                    val date = result.key!!
                    val value = result./*child(MOOD_ENTRY_ID_KEY).*/value!!

                    resultMap[date] = value as Map<String, Any>
                }
                val response = Query(
                    data = resultMap,
                    completed = true,
                    reason = stringStorage.getString(SUCCESS_LOAD_REASON_STR_ID)
                )
                callback.call(response)
            }

            override fun onCancelled(error: DatabaseError) {
                dbFirebaseQuery.removeEventListener(moodEntriesEventListener)

                val response = Query(
                    reason = stringStorage.getString(FAILURE_LOAD_REASON_STR_ID) + ". Exception: " + error.message
                )
                callback.call(response)
            }
        }
}