package com.niksob.domain.usecase.db

import com.niksob.domain.data.converter.DbMoodEntryConverter
import com.niksob.domain.data.converter.DbMoodTagConverter
import com.niksob.domain.data.dto.MoodTagDto
import com.niksob.domain.data.repository.MoodEntryRepository
import com.niksob.domain.data.repository.MoodTagRepository
import com.niksob.domain.model.*
import com.niksob.domain.usecase.UseCase

private const val SPLIT_REASON_SYM = ". "

@Suppress("UNCHECKED_CAST")
class LoadMoodEntriesByUserIdUseCase(
    private val entryRepo: MoodEntryRepository,
    private val tagRepo: MoodTagRepository,
    private val dbMoodEntryConverter: DbMoodEntryConverter,
    private val dbMoodTagConverter: DbMoodTagConverter,
) : UseCase {

    private lateinit var moodEntriesData: MoodEntriesData
    private lateinit var requestCallback: Callback<Query>

    private var moodEntriesResponseDto: Query? = null
    private var moodTagsResponseDto: Query? = null

    override fun execute(request: Query) {

        requestCallback = request.callback!!
        moodEntriesData = request.data as MoodEntriesData

        loadMoodEntries()
        loadMoodTags()
    }

    private fun loadMoodEntries() {
        val entryRequest = Query(
            data = dbMoodEntryConverter.toDto(moodEntriesData),
            callback = Callback { entriesResponseDto ->
                this.moodEntriesResponseDto = entriesResponseDto
                onDataLoaded()
            }
        )
        entryRepo.loadByUserIdAndDate(entryRequest)
    }

    private fun loadMoodTags() {
        val tagRequest = Query(
            data = dbMoodEntryConverter.toDto(moodEntriesData),
            callback = Callback { tagsResponseDto ->
                this.moodTagsResponseDto = tagsResponseDto
                onDataLoaded()
            }
        )
        tagRepo.loadByUserIdAndDate(tagRequest)
    }

    private fun onDataLoaded() {
        if (moodEntriesResponseDto == null || moodTagsResponseDto == null) {
            return
        }

        val entries = dbMoodEntryConverter.fromDto(moodEntriesResponseDto!!.data as List<MoodEntryDto>)
        val tags = dbMoodTagConverter.fromDto(moodTagsResponseDto!!.data as List<MoodTagDto>)

        entries.forEach { entry ->

            tags.forEach tagsForEach@{ tag ->

                if (entry.id != tag.entryId) {
                    return@tagsForEach
                }
                entry.tags.add(tag)
            }
        }

        val response = Query(
            data = entries,
            completed = moodEntriesResponseDto!!.completed && moodEntriesResponseDto!!.completed,
            reason = moodEntriesResponseDto!!.reason + SPLIT_REASON_SYM + moodTagsResponseDto!!.reason,
        )

        requestCallback.call(response)
    }
}