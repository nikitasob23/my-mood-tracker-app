package com.niksob.data.converter.mood_tag

import com.niksob.domain.data.converter.mood_tag.DbMoodTagConverter
import com.niksob.domain.data.dto.*
import com.niksob.domain.model.MoodEntryId
import com.niksob.domain.model.mood_tag.MoodTag
import com.niksob.domain.model.mood_tag.MoodTags

class DbMoodTagConverterImpl : DbMoodTagConverter {

    override fun fromDto(data: Any) =
        MoodTags(
            (data as MoodTagsDto).data.map { tagDto ->
                MoodTag(
                    id = tagDto.id,
                    entryId = tagDto.entryId,
                    name = tagDto.name,
                    degree = tagDto.degree,
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
            degree = tag.degree,
        )
}