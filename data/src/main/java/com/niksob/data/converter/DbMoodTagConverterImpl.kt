package com.niksob.data.converter

import com.niksob.domain.data.converter.DbMoodTagConverter
import com.niksob.domain.data.converter.MoodColorIdConverter
import com.niksob.domain.data.dto.MoodEntriesDto
import com.niksob.domain.data.dto.MoodTagDataDto
import com.niksob.domain.data.dto.MoodTagsDto
import com.niksob.domain.model.*

class DbMoodTagConverterImpl(
    private val colorIdConverter: MoodColorIdConverter,
) : DbMoodTagConverter {

    override fun toDto(data: Any): MoodTagDataDto {

        val moodEntries = data as MoodEntriesDto

        val tagToEntryIds = moodEntries.data
            .map { entry -> entry.id to entry.tagIds }
            .map { (entryId, tagIds) ->
                tagIds.map { tagId -> tagId to entryId }
            }
            .flatten()
            .groupBy({ it.first }, { it.second })

        return MoodTagDataDto(
            uid = moodEntries.uid,
            tagToEntryIds = tagToEntryIds,
        )
    }

    override fun fromDto(data: Any) =
        MoodTags(
            (data as MoodTagsDto).data.map { tagDto ->
                MoodTag(
                    id = tagDto.id,
                    entryId = tagDto.entryId,
                    name = tagDto.name,
                    colorId = colorIdConverter.getColorIdByMoodDegree(tagDto.degree),
                )
            }
        )
}