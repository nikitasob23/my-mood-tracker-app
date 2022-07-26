package com.niksob.domain.data.converter

import com.niksob.domain.data.dto.MoodEntriesDataDto
import com.niksob.domain.data.dto.MoodTagDto
import com.niksob.domain.model.MoodEntriesData
import com.niksob.domain.model.MoodEntry
import com.niksob.domain.model.MoodEntryDto

interface DbMoodEntryConverter {
    fun toDto(moodEntriesData: MoodEntriesData): MoodEntriesDataDto

    fun fromDto(moodEntriesDto: List<MoodEntryDto>, moodTagsDto: List<MoodTagDto>): List<MoodEntry>
}