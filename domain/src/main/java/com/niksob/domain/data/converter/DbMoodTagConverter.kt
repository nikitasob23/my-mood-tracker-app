package com.niksob.domain.data.converter

import com.niksob.domain.data.dto.MoodTagDto
import com.niksob.domain.model.MoodEntryDto
import com.niksob.domain.model.MoodTag
import com.niksob.domain.model.MoodTagDataDto

interface DbMoodTagConverter {

    fun toDto(moodEntries: List<MoodEntryDto>): MoodTagDataDto

    fun fromDto(moodTagsDto: List<MoodTagDto>): List<MoodTag>
}
