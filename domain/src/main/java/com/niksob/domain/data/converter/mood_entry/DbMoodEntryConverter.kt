package com.niksob.domain.data.converter.mood_entry

import com.niksob.domain.data.dto.MoodEntriesDataDto
import com.niksob.domain.model.mood_entry.MoodEntries
import com.niksob.domain.model.MoodEntriesData

interface DbMoodEntryConverter {
    fun toDto(moodEntriesData: MoodEntriesData): MoodEntriesDataDto

    fun fromDto(moodEntriesDto: Any, moodTagsDataDto: Any): MoodEntries

    fun fromFirebaseDto(moodEntriesDto: Any, moodTagsDto: Any): MoodEntries
}