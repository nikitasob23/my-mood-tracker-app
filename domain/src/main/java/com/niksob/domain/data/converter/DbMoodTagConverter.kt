package com.niksob.domain.data.converter

import com.niksob.domain.data.dto.*
import com.niksob.domain.model.MoodTags

interface DbMoodTagConverter {

    fun toDto(data: Any): MoodTagDataDto

    fun fromDto(data: Any): MoodTags
}
