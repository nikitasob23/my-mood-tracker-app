package com.niksob.domain.data.dto

import com.niksob.domain.model.MoodEntryId
import com.niksob.domain.model.MoodTagId
import com.niksob.domain.data.dto.DbFirebaseMoodEntryKey.DEGREE
import com.niksob.domain.data.dto.DbFirebaseMoodEntryKey.TIME
import com.niksob.domain.data.dto.DbFirebaseMoodEntryKey.TAG_IDS
import com.niksob.domain.model.Uid

enum class DbFirebaseMoodEntryKey(val key: String) {
    DEGREE("degree"),
    TIME("time"),
    TAG_IDS("tagIds"),
}

data class MoodEntryDto(
    val id: MoodEntryId,
    val degree: Int,
    val date: String,
    val time: String,
    val tagIds: List<MoodTagId>,
) {

    fun toMap(uid: Uid) =
        mapOf(
            uid.data to dateToEntryIdAndDataMap
        )

    private val dateToEntryIdAndDataMap
        get() = mapOf(
            date to idToEntryMap
        )

    private val idToEntryMap
        get() = mapOf(
            id.data to entryMap
        )

    private val entryMap
        get() = mapOf(
            DEGREE.key to degree,
            TIME.key to time,
            TAG_IDS.key to tagIds,
        )
}
