package com.niksob.domain.data.converter

import com.niksob.domain.data.dto.MoodEntriesDataDto
import com.niksob.domain.model.MoodEntriesData
import com.niksob.domain.model.MoodEntry

interface DbMoodEntryConverter {
    fun toDto(moodEntriesData: MoodEntriesData): MoodEntriesDataDto

    fun fromDto(moodEntryDto: Map<String, Any>, uid: String): List<MoodEntry>
}