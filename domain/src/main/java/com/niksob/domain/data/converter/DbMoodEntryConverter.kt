package com.niksob.domain.data.converter

import com.niksob.domain.data.dto.MoodEntriesDataDto
import com.niksob.domain.model.MoodEntriesData
import com.niksob.domain.model.MoodEntries

interface DbMoodEntryConverter {
    fun toDto(moodEntriesData: MoodEntriesData): MoodEntriesDataDto

    fun fromDto(moodEntriesDto: Any, moodTagsDataDto: Any): MoodEntries

    fun fromFirebaseDto(moodEntriesDto: Any, moodTagsDto: Any): MoodEntries
}