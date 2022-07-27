package com.niksob.domain.model

data class MoodTag(
    val id: MoodTagId,
    val entryId: MoodEntryId,
    val name: String,
    val colorId: Int,
)
