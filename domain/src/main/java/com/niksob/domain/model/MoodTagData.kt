package com.niksob.domain.model

data class MoodTagData(
    val uid: String,
    val entryToTagIds: Map<String, List<String>>,
)