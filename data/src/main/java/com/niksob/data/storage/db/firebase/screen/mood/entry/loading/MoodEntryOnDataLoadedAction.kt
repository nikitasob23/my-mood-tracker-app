package com.niksob.data.storage.db.firebase.screen.mood.entry.loading

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.niksob.data.provider.ResponseReasonProvider
import com.niksob.data.storage.db.firebase.loader.OnDataLoadedAction
import com.niksob.domain.data.dto.MoodEntriesDto
import com.niksob.domain.data.dto.MoodEntryDto
import com.niksob.domain.model.MoodEntryId
import com.niksob.domain.model.MoodTagId
import com.niksob.domain.model.Query
import com.niksob.domain.model.Uid

private const val DEGREE_KEY = "degree"
private const val TIME_KEY = "time"
private const val TAG_IDS_KEY = "tagIds"

class MoodEntryOnDataLoadedAction(
    private val reasonProvider: ResponseReasonProvider,
) : OnDataLoadedAction {

    override fun onDataLoaded(userIdSnapshot: DataSnapshot, request: Query) {

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
            completed = reasonProvider.successStatus,
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