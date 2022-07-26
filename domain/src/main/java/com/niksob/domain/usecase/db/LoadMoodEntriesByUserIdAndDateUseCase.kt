package com.niksob.domain.usecase.db

import com.niksob.domain.data.converter.DbMoodEntryConverter
import com.niksob.domain.data.converter.DbMoodTagConverter
import com.niksob.domain.data.dto.MoodTagDto
import com.niksob.domain.data.repository.MoodEntryRepository
import com.niksob.domain.data.repository.MoodTagRepository
import com.niksob.domain.model.*
import com.niksob.domain.usecase.UseCase

class LoadMoodEntriesByUserIdAndDateUseCase(
    private val entryRepo: MoodEntryRepository,
    private val tagRepo: MoodTagRepository,
    private val dbMoodEntryConverter: DbMoodEntryConverter,
    private val dbMoodTagConverter: DbMoodTagConverter,
) : UseCase {

    private lateinit var callback: Callback<Query>

    override fun execute(request: Query) {

        callback = request.callback!!

        val entriesRequest = Query(
            data = dbMoodEntryConverter.toDto(request.data as MoodEntriesData),
            callback = Callback { moodEntriesResponse ->
                onMoodEntriesLoaded(moodEntriesResponse)
            }
        )
        entryRepo.loadByUserIdAndDate(entriesRequest)
    }

    private fun onMoodEntriesLoaded(moodEntriesResponse: Query) {

        val tagsRequest = Query(
            data = dbMoodTagConverter.toDto(moodEntriesResponse.data as List<MoodEntryDto>),
            callback = Callback { tagsResponse ->
                onMoodTagsLoaded(moodEntriesResponse, tagsResponse)
            }
        )
        tagRepo.loadByEntryId(tagsRequest)
    }

    private fun onMoodTagsLoaded(entriesResponse: Query, tagsResponse: Query) {

        val tags = tagsResponse.data as List<MoodTagDto>

        val response = Query(
            data = dbMoodEntryConverter.fromDto(entriesResponse.data as List<MoodEntryDto>, tags),
            completed = entriesResponse.completed,
            reason = entriesResponse.reason,
        )
        callback.call(response)
    }
}