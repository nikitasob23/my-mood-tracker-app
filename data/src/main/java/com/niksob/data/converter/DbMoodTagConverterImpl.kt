package com.niksob.data.converter

import com.niksob.domain.data.converter.DbMoodTagConverter
import com.niksob.domain.data.converter.MoodColorIdConverter
import com.niksob.domain.data.dto.*
import com.niksob.domain.model.*

class DbMoodTagConverterImpl(
    private val colorIdConverter: MoodColorIdConverter,
) : DbMoodTagConverter {

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

    override fun toDto(data: Any): MoodTagDataDto {
        data as MoodEntriesDto

        return MoodTagDataDto(
            uid = data.uid,
            tagToEntryIds = tagToEntryIdsMapping(data),
        )
    }

    override fun fromFirebaseDto(
        tagsFirebaseDto: MoodTagsFirebaseDto,
        entriesDataDto: MoodEntriesDto,
    ): MoodTags {

        val tagIdToEntryIds = tagToEntryIdsMapping(entriesDataDto)

        val tagIdFilter: (MoodTagFirebaseDto) -> Boolean = { tag ->
            tagIdToEntryIds.keys.contains(tag.id)
        }

        val moodTagList = tagsFirebaseDto.data.filter(tagIdFilter)
            .flatMap { tag ->
                tagIdToEntryIds[tag.id]!!.map { entryId -> moodTagMapping(tag, entryId) }
            }
        return MoodTags(moodTagList)
    }

    private fun tagToEntryIdsMapping(moodEntries: MoodEntriesDto) =
        moodEntries.data
            .map { entry -> entry.id to entry.tagIds }
            .flatMap { (entryId, tagIds) ->
                tagIds.map { tagId -> tagId to entryId }
            }
            .groupBy({ it.first }, { it.second })

    private fun moodTagMapping(tag: MoodTagFirebaseDto, entryId: MoodEntryId) =
        MoodTag(
            id = tag.id,
            entryId = entryId,
            name = tag.name,
            colorId = colorIdConverter.getColorIdByMoodDegree(tag.degree)
        )
}