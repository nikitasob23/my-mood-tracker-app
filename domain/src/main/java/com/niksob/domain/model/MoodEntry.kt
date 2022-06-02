package com.niksob.domain.model

import java.time.ZonedDateTime


@Suppress("NewApi")
data class MoodEntry(
    val id: String = "",
    val uid: String,
    val dateTime: ZonedDateTime = ZonedDateTime.now(),
    val degree: Int = -1,
    val tags: List<MoodTag> = ArrayList()
)