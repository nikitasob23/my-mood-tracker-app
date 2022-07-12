package com.niksob.data.converter

import com.niksob.domain.data.converter.DbMoodTagConverter
import com.niksob.domain.data.converter.MoodColorIdConverter
import com.niksob.domain.data.dto.MoodTagDto
import com.niksob.domain.model.MoodTag

class DbMoodTagConverterImpl(
    private val colorIdConverter: MoodColorIdConverter,
) : DbMoodTagConverter {

    override fun fromDto(moodTagsDto: List<MoodTagDto>): List<MoodTag> {

        val moodTags = ArrayList<MoodTag>()
        moodTagsDto.forEach { tagDto ->

            val tag = MoodTag(
                id = tagDto.id,
                entryId = tagDto.entryId,
                name = tagDto.name,
                colorId = colorIdConverter.getColorIdByMoodDegree(tagDto.degree),
            )
            moodTags.add(tag)
        }
        return moodTags
    }
}