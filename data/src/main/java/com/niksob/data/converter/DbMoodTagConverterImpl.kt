package com.niksob.data.converter

import com.niksob.domain.data.converter.DbMoodTagConverter
import com.niksob.domain.data.converter.MoodColorIdConverter
import com.niksob.domain.data.dto.MoodEntriesDto
import com.niksob.domain.model.MoodTag
import com.niksob.domain.model.MoodTagData
import com.niksob.domain.data.dto.MoodTagDataDto
import com.niksob.domain.data.dto.MoodTagsDto
import com.niksob.domain.model.MoodTags

class DbMoodTagConverterImpl(
    private val colorIdConverter: MoodColorIdConverter,
) : DbMoodTagConverter {

    override fun toDto(data: Any): MoodTagDataDto {

        val moodEntries = data as MoodEntriesDto

        val tagToEntryIds = moodEntries.data.map { entry ->
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
            uid = moodEntries.data[0].uid,
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