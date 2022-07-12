package com.niksob.data.storage.db.firebase

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.niksob.data.provider.DbProvider
import com.niksob.data.storage.db.MoodTagStorage
import com.niksob.data.storage.provider.AppStringStorage
import com.niksob.domain.data.dto.MoodEntriesDataDto
import com.niksob.domain.data.dto.MoodTagDto
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query

private const val MOOD_TAGS_DB_REF_NAME = "mood_tags"
private const val MOOD_ENTRY_TO_TAG_DB_REF_NAME = "mood_entry_to_tag"
private const val DEGREE_KEY = "degree"
private const val NAME_KEY = "name"

private const val SUCCESS_LOAD_TAGS_REASON_STR_ID = "mood_tags_was_load"
private const val FAILURE_LOAD_TAGS_REASON_STR_ID = "mood_tags_was_not_load"
private const val FAILURE_LOAD_TAG_IDS_REASON_STR_ID = "failure_load_tag_ids"
private const val SUCCESS_SAVING_TAGS_REASON_STR_ID = "success_saving"
private const val FAILURE_SAVING_TAGS_REASON_STR_ID = "failure_saving"
private const val EXCEPTION_MESSAGE_PREFIX = ". Exception message: "
private const val SUCCESS_STATUS = true

class DbMoodTagFirebase(
    private val dbProvider: DbProvider,
    private val stringStorage: AppStringStorage,
) : MoodTagStorage {

    private lateinit var entriesDataDto: MoodEntriesDataDto

    private lateinit var callback: Callback<Query>

    private val tags = ArrayList<MoodTagDto>()

    private val resultTagDto = ArrayList<MoodTagDto>()

    private val moodTagIdsEventListener
        get() = object : ValueEventListener {

            override fun onDataChange(uidSnapshot: DataSnapshot) {

                val uid = uidSnapshot.key!!

                uidSnapshot.children.forEach { dateSnapshot ->

                    dateSnapshot.children.forEach { entryIdSnapshot ->

                        val entryId = entryIdSnapshot.key!!

                        entryIdSnapshot.children.forEach { tagIdSnapshot ->

                            val tagId = tagIdSnapshot.getValue(String::class.java)!!

                            val tagDto = MoodTagDto(
                                id = tagId,
                                entryId = entryId,
                                uid = uid,
                            )
                            tags.add(tagDto)
                        }
                    }
                }
                loadTagsById()
            }

            override fun onCancelled(error: DatabaseError) {

                val tagIdsResponse = Query(
                    reason = failureLoadTagIdsReason(error.message)
                )
                callback.call(tagIdsResponse)
            }
        }

    private val moodTagsEventListener
        get() = object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                snapshot.children.forEach { tagIdSnapshot ->

                    val tagId = tagIdSnapshot.key!!

                    tags.forEach { tag ->

                        if (tag.id == tagId) {
                            addMoodTag(tag, tagIdSnapshot)
                        }
                    }
                }

                val tagsResponse = Query(
                    data = resultTagDto,
                    completed = SUCCESS_STATUS,
                    reason = successLoadTagsReason()
                )

                callback.call(tagsResponse)
            }

            override fun onCancelled(error: DatabaseError) {
                val tagResponse = Query(
                    reason = failureLoadTagsReason(error.message)
                )
                callback.call(tagResponse)
            }

        }

    private fun addMoodTag(tag: MoodTagDto, snapshot: DataSnapshot) {

        val degree = snapshot.child(DEGREE_KEY)
            .getValue(Int::class.java)!!
        val name = snapshot.child(NAME_KEY)
            .getValue(String::class.java)!!

        val tagDto = MoodTagDto(
            id = tag.id,
            entryId = tag.entryId,
            degree = degree,
            name = name,
        )
        resultTagDto.add(tagDto)
    }

    private fun loadTagsById() {

        dbProvider.getDbReference()
            .child(MOOD_TAGS_DB_REF_NAME)
            .child(entriesDataDto.uid)
            .addListenerForSingleValueEvent(moodTagsEventListener)
    }

    private fun successSaveTagsReason() = stringStorage.getString(SUCCESS_SAVING_TAGS_REASON_STR_ID)

    private fun successLoadTagsReason() = stringStorage.getString(SUCCESS_LOAD_TAGS_REASON_STR_ID)

    private fun failureSaveTagsReason(failureMessage: String?) =
        stringStorage.getString(FAILURE_SAVING_TAGS_REASON_STR_ID) + failureMessage.let { EXCEPTION_MESSAGE_PREFIX + it }

    private fun failureLoadTagsReason(failureMessage: String?) =
        stringStorage.getString(FAILURE_LOAD_TAGS_REASON_STR_ID) + failureMessage.let { EXCEPTION_MESSAGE_PREFIX + it }

    private fun failureLoadTagIdsReason(failureMessage: String?) =
        stringStorage.getString(FAILURE_LOAD_TAG_IDS_REASON_STR_ID) + failureMessage.let { EXCEPTION_MESSAGE_PREFIX + it }

    override fun loadByUserIdAndDate(request: Query) {

        entriesDataDto = request.data as MoodEntriesDataDto
        callback = request.callback!!

        dbProvider.getDbReference()
            .child(MOOD_ENTRY_TO_TAG_DB_REF_NAME)
            .child(entriesDataDto.uid)
            .orderByKey()
            .startAt(entriesDataDto.startDate)
            .endAt(entriesDataDto.endDate)
            .addListenerForSingleValueEvent(moodTagIdsEventListener)
    }

    @Suppress("UNCHECKED_CAST")
    override fun save(request: Query) {

        callback = request.callback!!
        val tagDto = request.data as MoodTagDto

        insertToMoodTagsRef(tagDto)
        insertToMoodEntryToTagsRef(tagDto)
    }

    private fun insertToMoodTagsRef(tagDto: MoodTagDto) {

        val tagsRef = dbProvider.getDbReference()
            .child(MOOD_TAGS_DB_REF_NAME)
            .child(tagDto.uid)
            .child(tagDto.id)

        setValueToDbRef(tagsRef, DEGREE_KEY, tagDto.degree)
        setValueToDbRef(tagsRef, NAME_KEY, tagDto.name)
    }

    private fun insertToMoodEntryToTagsRef(tagDto: MoodTagDto) {

        val entryToTagsRef = dbProvider.getDbReference()
            .child(MOOD_ENTRY_TO_TAG_DB_REF_NAME)
            .child(tagDto.uid)
            .child(tagDto.date)
            .child(tagDto.id)

        val newKey = entryToTagsRef.push().key!!
        setValueToDbRef(entryToTagsRef, newKey, tagDto.entryId)
    }

    private fun setValueToDbRef(ref: DatabaseReference, key: String, value: Any) {
        ref.child(key)
            .setValue(value)
            .addOnCompleteListener(moodEntryCompleteListener)
    }

    private val moodEntryCompleteListener = OnCompleteListener<Void> { task ->

        val entryResponse =
            if (task.isSuccessful)
                Query(completed = SUCCESS_STATUS, reason = successSaveTagsReason())
            else
                Query(reason = failureSaveTagsReason(task.exception?.message))
        callback.call(entryResponse)
    }
}