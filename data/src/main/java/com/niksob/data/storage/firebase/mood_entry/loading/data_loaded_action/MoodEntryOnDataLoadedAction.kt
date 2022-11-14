package com.niksob.data.storage.firebase.mood_entry.loading.data_loaded_action

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.niksob.data.provider.ResponseReasonProvider
import com.niksob.domain.data.dto.MoodEntriesDto
import com.niksob.domain.data.dto.MoodEntryDto
import com.niksob.domain.model.MoodEntryId
import com.niksob.domain.model.MoodTagId
import com.niksob.domain.model.Query
import com.niksob.domain.model.Uid
import com.niksob.data.model.DbFirebaseMoodEntryKey.DEGREE
import com.niksob.data.model.DbFirebaseMoodEntryKey.TIME
import com.niksob.data.model.DbFirebaseMoodEntryKey.TAG_IDS
import com.niksob.data.storage.firebase.base.loader.OnDataLoadedAction

class MoodEntryOnDataLoadedAction(
    private val reasonProvider: ResponseReasonProvider,
) : OnDataLoadedAction {

    override fun onDataLoaded(userIdSnapshot: DataSnapshot, request: Query) {

        val loadedMoodEntries = userIdSnapshot.children.map { dateSnapshot ->
            dateSnapshot.children.map { idSnapshot ->
                MoodEntryDto(
                    id = MoodEntryId(idSnapshot.key!!),
                    date = dateSnapshot.key!!,
                    degree = idSnapshot.child(DEGREE.key)
                        .getValue(Int::class.java)!!,
                    time = idSnapshot.child(TIME.key)
                        .getValue(String::class.java)!!,
                    tagIds = idSnapshot.child(TAG_IDS.key).children
                        .map { tagIdSnapshot -> MoodTagId(tagIdSnapshot.key!!) },
                )
            }
        }.flatten()

        val response = Query(
            data = MoodEntriesDto(uid = Uid(userIdSnapshot.key!!), data = loadedMoodEntries),
            completed = true,
            reason = reasonProvider.successfulReason
        )
        val callback = request.callback!!
        callback.call(response)
    }

    override fun onDataCancelled(error: DatabaseError, request: Query) {

        val response = Query(
            reason = reasonProvider.failureReason(error.message)
        )
        val callback = request.callback!!
        callback.call(response)
    }
}