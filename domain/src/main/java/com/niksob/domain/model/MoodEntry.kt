package com.niksob.domain.model

import java.time.ZonedDateTime


@Suppress("NewApi")
data class MoodEntry(
    val id: String = "",
    val dateTime: ZonedDateTime = ZonedDateTime.now(),
    val colorId: Int = -1,
    val emojiId: Int = -1,
    val tags: List<MoodTag> = ArrayList(),
)