package com.niksob.domain.model.mood_entry

import com.niksob.domain.model.MoodEntryId
import com.niksob.domain.model.mood_tag.MoodTag
import java.time.ZonedDateTime

@Suppress("NewApi")
data class MoodEntry(
    val id: MoodEntryId,
    val dateTime: ZonedDateTime = ZonedDateTime.now(),
    val degree: Int = -1,
    val tags: List<MoodTag> = ArrayList(),
)