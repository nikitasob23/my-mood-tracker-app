package com.niksob.domain.data.dto

import com.niksob.domain.model.MoodEntryId
import com.niksob.domain.model.MoodTagId

data class MoodEntryDto(
    val id: MoodEntryId,
    val degree: Int,
    val date: String,
    val time: String,
    val tagIds: List<MoodTagId>,
)
