package com.niksob.data.storage.db.firebase.screen.mood.entry

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.niksob.domain.data.dto.MoodEntriesDto
import com.niksob.domain.data.dto.MoodEntryDto
import com.niksob.domain.model.*

private const val DEGREE_KEY = "degree"
private const val TIME_KEY = "time"
private const val TAG_IDS_KEY = "tagIds"

class MoodEntriesValueEventFirebaseProvider(
    private val loadReasonProvider: MoodEntryLoadResponseReasonProvider,
) {

    fun getListener(callback: Callback<Query>) = object : ValueEventListener {

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
}