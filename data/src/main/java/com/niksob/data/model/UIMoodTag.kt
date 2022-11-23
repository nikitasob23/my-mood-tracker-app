package com.niksob.data.model

import com.niksob.domain.model.MoodEntryId
import com.niksob.domain.model.MoodTagId

data class UIMoodTag(
    val id: MoodTagId,
    val entryId: MoodEntryId,
    val name: String,
    val colorId: Int,
)
