package com.niksob.domain.model

data class MoodTagDataDto(
    val uid: String,
    val tagToEntryIds: Map<String, List<String>>,
)