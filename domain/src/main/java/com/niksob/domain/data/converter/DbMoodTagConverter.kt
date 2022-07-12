package com.niksob.domain.data.converter

import com.niksob.domain.data.dto.MoodTagDto
import com.niksob.domain.model.MoodTag

interface DbMoodTagConverter {

    fun fromDto(moodTagsDto: List<MoodTagDto>): List<MoodTag>
}
