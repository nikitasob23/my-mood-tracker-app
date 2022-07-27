package com.niksob.data.storage.db.firebase.moodentry

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.niksob.data.storage.provider.AppStringStorage
import com.niksob.domain.data.dto.MoodTagDto
import com.niksob.domain.model.Callback
import com.niksob.domain.data.dto.MoodTagDataDto
import com.niksob.domain.model.MoodTagId
import com.niksob.domain.model.Query
import com.niksob.domain.model.Uid

private const val DEGREE_KEY = "degree"
private const val NAME_KEY = "name"

private const val SUCCESS_LOAD_TAGS_REASON_STR_ID = "mood_tags_was_load"
private const val FAILURE_LOAD_TAGS_REASON_STR_ID = "mood_tags_was_not_load"
private const val SUCCESS_SAVING_TAGS_REASON_STR_ID = "success_saving"
private const val FAILURE_SAVING_TAGS_REASON_STR_ID = "failure_saving"
private const val EXCEPTION_MESSAGE_PREFIX = ". Exception message: "
private const val SUCCESS_STATUS = true

class MoodTagsValueEventFirebaseProvider(
    private val stringStorage: AppStringStorage,
) {

    fun getListener(moodTagDataDto: MoodTagDataDto, callback: Callback<Query>) =
        object : ValueEventListener {
            override fun onDataChange(userIdSnapshot: DataSnapshot) {

                val uid = userIdSnapshot.key!!

                val moodTagsDto = userIdSnapshot.children
                    .filter { filterByRequestTagIds(it) }
                    .flatMap { flatToMoodTagDto(it, uid) }

                val response = Query(
                    data = moodTagsDto,
                    completed = true,
                    reason = successLoadTagsReason()
                )
                callback.call(response)
            }

            override fun onCancelled(error: DatabaseError) {
                val errorResponse = Query(
                    reason = failureLoadTagIdsReason(error.message)
                )
                callback.call(errorResponse)
            }

            private fun flatToMoodTagDto(idSnapshot: DataSnapshot, uid: String): List<MoodTagDto> {
                val id = MoodTagId(idSnapshot.key!!)
                return moodTagDataDto.tagToEntryIds[id]!!.map { entryId ->
                    MoodTagDto(
                        id = id,
                        uid = Uid(uid),
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

    private fun failureLoadTagIdsReason(failureMessage: String?) =
        stringStorage.getString(FAILURE_LOAD_TAGS_REASON_STR_ID) +
                failureMessage.let { EXCEPTION_MESSAGE_PREFIX + it }

    private fun successLoadTagsReason() = stringStorage.getString(SUCCESS_LOAD_TAGS_REASON_STR_ID)
}