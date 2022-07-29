package com.niksob.domain.data.dto

import com.niksob.domain.model.Uid

data class MoodEntryForSaveDto(
    val uid: Uid,
    val data: MoodEntryDto,
)
