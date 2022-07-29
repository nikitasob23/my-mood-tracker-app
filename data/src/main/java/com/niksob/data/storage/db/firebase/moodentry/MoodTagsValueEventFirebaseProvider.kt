package com.niksob.data.storage.db.firebase.moodentry

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.niksob.domain.data.dto.MoodTagDto
import com.niksob.domain.model.Callback
import com.niksob.domain.data.dto.MoodTagDataDto
import com.niksob.domain.data.dto.MoodTagsDto
import com.niksob.domain.model.MoodTagId
import com.niksob.domain.model.Query

private const val DEGREE_KEY = "degree"
private const val NAME_KEY = "name"

class MoodTagsValueEventFirebaseProvider(
    private val loadReasonProvider: ResponseReasonProvider,
) {

    fun getListener(moodTagDataDto: MoodTagDataDto, callback: Callback<Query>) =
        object : ValueEventListener {
            override fun onDataChange(userIdSnapshot: DataSnapshot) {

                val moodTagsDto = userIdSnapshot.children
                    .filter { filterByRequestTagIds(it) }
                    .flatMap { flatToMoodTagDto(it) }

                val response = Query(
                    data = MoodTagsDto(moodTagsDto),
                    completed = loadReasonProvider.successStatus,
                    reason = loadReasonProvider.successfulReason
                )
                callback.call(response)
            }

            override fun onCancelled(error: DatabaseError) {
                val errorResponse = Query(
                    reason = loadReasonProvider.failureReason(error.message)
                )
                callback.call(errorResponse)
            }

            private fun flatToMoodTagDto(idSnapshot: DataSnapshot): List<MoodTagDto> {
                val id = MoodTagId(idSnapshot.key!!)
                return moodTagDataDto.tagToEntryIds[id]!!.map { entryId ->
                    MoodTagDto(
                        id = id,
                        degree = idSnapshot.child(DEGREE_KEY)
                            .getValue(Int::class.java)!!,
                        name = idSnapshot.child(NAME_KEY)
                            .getValue(String::class.java)!!,
                        entryId = entryId,
                    )
                }
            }

            private fun filterByRequestTagIds(idSnapshot: DataSnapshot): Boolean {
                val id = MoodTagId(idSnapshot.key!!) //can try to take it outside "stream"
                return moodTagDataDto.tagToEntryIds[id] != null
            }
        }
}