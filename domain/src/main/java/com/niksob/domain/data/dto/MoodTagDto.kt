package com.niksob.domain.data.dto

import com.niksob.domain.model.MoodEntryId
import com.niksob.domain.model.MoodTagId
import com.niksob.domain.model.Uid

data class MoodTagDto(
    val id: MoodTagId,
    val uid: Uid,
    val degree: Int,
    val name: String,
    val entryId: MoodEntryId,
)
