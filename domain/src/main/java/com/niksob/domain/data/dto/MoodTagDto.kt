package com.niksob.domain.data.dto

import com.niksob.domain.model.MoodEntryId
import com.niksob.domain.model.MoodTagId

data class MoodTagDto(
    val id: MoodTagId,
    val degree: Int,
    val name: String,
    val entryId: MoodEntryId,
)
