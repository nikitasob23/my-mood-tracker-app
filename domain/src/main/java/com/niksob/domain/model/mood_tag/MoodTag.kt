package com.niksob.domain.model.mood_tag

import com.niksob.domain.model.MoodEntryId
import com.niksob.domain.model.MoodTagId

data class MoodTag(
    val id: MoodTagId,
    val entryId: MoodEntryId,
    val name: String,
    val degree: Int,
)