package com.niksob.data.storage.firebase.mood.tag.loading.data_loaded_action

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.niksob.data.provider.ResponseReasonProvider
import com.niksob.domain.data.dto.MoodTagDataDto
import com.niksob.domain.data.dto.MoodTagDto
import com.niksob.domain.data.dto.MoodTagsDto
import com.niksob.domain.model.MoodTagId
import com.niksob.domain.model.Query
import com.niksob.data.model.DbFirebaseMoodTagKey.DEGREE
import com.niksob.data.model.DbFirebaseMoodTagKey.NAME
import com.niksob.data.storage.firebase.base.loader.OnDataLoadedAction

class MoodTagOnDataLoadedAction(
    private val loadReasonProvider: ResponseReasonProvider,
): OnDataLoadedAction {

    override fun onDataLoaded(userIdSnapshot: DataSnapshot, request: Query) {
        val moodTagsDto = userIdSnapshot.children
            .filter { filterByRequestTagIds(it, request) }
            .flatMap { flatToMoodTagDto(it, request) }

        val response = Query(
            data = MoodTagsDto(moodTagsDto),
            completed = true,
            reason = loadReasonProvider.successfulReason
        )
        val callback = request.callback!!
        callback.call(response)
    }

    override fun onDataCancelled(error: DatabaseError, request: Query) {
        val errorResponse = Query(
            reason = loadReasonProvider.failureReason(error.message)
        )
        val callback = request.callback!!
        callback.call(errorResponse)
    }

    private fun flatToMoodTagDto(idSnapshot: DataSnapshot, request: Query): List<MoodTagDto> {
        val id = MoodTagId(idSnapshot.key!!)
        return (request.data as MoodTagDataDto).tagToEntryIds[id]!!.map { entryId ->
            MoodTagDto(
                id = id,
                degree = idSnapshot.child(DEGREE.key)
                    .getValue(Int::class.java)!!,
                name = idSnapshot.child(NAME.key)
                    .getValue(String::class.java)!!,
                entryId = entryId,
            )
        }
    }

    private fun filterByRequestTagIds(idSnapshot: DataSnapshot, request: Query): Boolean {
        val id = MoodTagId(idSnapshot.key!!) //can try to take it outside "stream"
        return (request.data as MoodTagDataDto).tagToEntryIds[id] != null
    }
}