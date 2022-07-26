package com.niksob.domain.model

data class MoodEntryDto(
    val id: String,
    val uid: String,
    val degree: Int,
    val date: String,
    val time: String,
    val tagIds: List<String>,
)
