package com.niksob.domain.data.dto

import com.niksob.domain.model.Uid

data class MoodEntriesDataDto(
    val uid: Uid,
    val startDate: String,
    val endDate: String,
)
