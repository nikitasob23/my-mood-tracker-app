package com.niksob.data.converter

import com.niksob.domain.data.converter.DbMoodTagConverter
import com.niksob.domain.data.converter.MoodColorIdConverter
import com.niksob.domain.data.dto.MoodTagDto
import com.niksob.domain.model.MoodEntryDto
import com.niksob.domain.model.MoodTag
import com.niksob.domain.model.MoodTagData
import com.niksob.domain.model.MoodTagDataDto

class DbMoodTagConverterImpl(
    private val colorIdConverter: MoodColorIdConverter,
) : DbMoodTagConverter {

    override fun toDto(moodEntries: List<MoodEntryDto>): MoodTagDataDto {

        val tagToEntryIds = moodEntries.map { entry ->
            val tagData = MoodTagData(
                uid = entry.uid,
                entryToTagIds = mapOf(entry.id to entry.tagIds),
            )
            tagData.entryToTagIds
                .map { (entryId, tagIds) -> tagIds.map { it to entryId } }
                .flatten()
                .groupBy({ it.first }, { it.second })

        }.reduce { map1, map2 -> map1.plus(map2) }

        return MoodTagDataDto(
            uid = moodEntries[0].uid,
            tagToEntryIds = tagToEntryIds,
        )
    }

    override fun fromDto(moodTagsDto: List<MoodTagDto>) =
        moodTagsDto.map { tagDto ->
            MoodTag(
                id = tagDto.id,
                entryId = tagDto.entryId,
                name = tagDto.name,
                colorId = colorIdConverter.getColorIdByMoodDegree(tagDto.degree),
            )
        }
}