package com.niksob.domain.data.dto

import com.niksob.domain.model.MoodEntryId
import com.niksob.domain.model.MoodTagId
import com.niksob.domain.model.Uid

data class MoodTagDataDto(
    val uid: Uid,
    val tagToEntryIds: Map<MoodTagId, List<MoodEntryId>>,
)