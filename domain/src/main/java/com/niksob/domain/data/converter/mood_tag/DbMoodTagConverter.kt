package com.niksob.domain.data.converter.mood_tag

import com.niksob.domain.data.dto.MoodEntriesDto
import com.niksob.domain.data.dto.MoodTagDataDto
import com.niksob.domain.data.dto.MoodTagsFirebaseDto
import com.niksob.domain.model.mood_tag.MoodTags

interface DbMoodTagConverter {

    fun toDto(data: Any): MoodTagDataDto

    fun fromDto(data: Any): MoodTags

    fun fromFirebaseDto(tagsFirebaseDto: MoodTagsFirebaseDto, entriesDataDto: MoodEntriesDto): MoodTags
}