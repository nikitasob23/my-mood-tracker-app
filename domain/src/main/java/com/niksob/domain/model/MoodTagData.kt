package com.niksob.domain.model

data class MoodTagData(
    val uid: Uid,
    val entryToTagIds: Map<MoodEntryId, List<MoodTagId>>,
)