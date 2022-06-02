package com.niksob.domain.data.dto.converter

import com.niksob.domain.model.MoodEntry
import com.niksob.domain.utils.date.utcDate
import com.niksob.domain.utils.date.utcTime


private const val DEGREE_KEY = "degree"
private const val TIME_KEY = "time"
private const val SPLIT_SYM = "/"

class DbMoodEntryConverter {
    companion object {

        fun toDto(moodEntry: MoodEntry): Map<String, Any> {

            val entryId = if (moodEntry.id.isNotEmpty()) SPLIT_SYM + moodEntry.id else ""
            val uid = if (moodEntry.uid.isNotEmpty()) SPLIT_SYM + moodEntry.uid else ""
            val date = SPLIT_SYM + moodEntry.dateTime.utcDate

            val moodEntryPath = uid + date + entryId

            val degreeTimeMap = mapOf(
                DEGREE_KEY to moodEntry.degree,
                TIME_KEY to moodEntry.dateTime.utcTime,
            )

            return mapOf(
                moodEntryPath to degreeTimeMap
            )
        }

        fun fromDto() {

        }
    }
}