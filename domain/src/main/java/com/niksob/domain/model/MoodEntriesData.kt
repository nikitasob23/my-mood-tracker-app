package com.niksob.domain.model

import java.time.ZonedDateTime

data class MoodEntriesData(
    val uid: Uid,
    val dateTime: ZonedDateTime,
    val loadedDaysInterval: Int,
)
