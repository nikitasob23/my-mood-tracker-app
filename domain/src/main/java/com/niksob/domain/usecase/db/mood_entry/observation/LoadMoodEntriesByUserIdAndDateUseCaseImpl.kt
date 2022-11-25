package com.niksob.domain.usecase.db.mood_entry.observation

import com.niksob.domain.data.converter.mood_entry.DbMoodEntryConverter
import com.niksob.domain.data.converter.mood_tag.DbMoodTagConverter
import com.niksob.domain.data.dto.*
import com.niksob.domain.data.repository.mood_entry.observation.loading.ObservableLoadableMoodEntryRepository
import com.niksob.domain.data.repository.mood_tag.observation.loading.ObservableLoadableMoodTagRepository
import com.niksob.domain.model.mood_entry.MoodEntries
import com.niksob.domain.model.MoodEntriesData
import io.reactivex.Single

class LoadMoodEntriesByUserIdAndDateUseCaseImpl(
    private val moodEntryRepository: ObservableLoadableMoodEntryRepository<MoodEntriesDataDto, MoodEntriesDto>,
    private val moodTagRepository: ObservableLoadableMoodTagRepository<MoodTagDataDto, MoodTagsFirebaseDto>,
    private val moodEntryConverter: DbMoodEntryConverter,
    private val moodTagConverter: DbMoodTagConverter,
): LoadMoodEntriesByUserIdAndDateUseCase {

    override fun execute(moodEntriesData: MoodEntriesData): Single<MoodEntries> {

        val observableMoodEntries = observableMoodEntries(moodEntriesData)
        val observableMoodTags = observableMoodEntries.flatMap(this::observableMoodTags)

        return Single.zip(
            observableMoodEntries,
            observableMoodTags,
            moodEntryConverter::fromFirebaseDto,
        )
    }

    private fun observableMoodEntries(moodEntriesData: MoodEntriesData) =
        listOf(moodEntriesData)
            .map(moodEntryConverter::toDto)
            .map(moodEntryRepository::loadByDateInterval)
            .first()

    private fun observableMoodTags(moodEntriesDto: MoodEntriesDto) =
        listOf(moodEntriesDto)
            .map(moodTagConverter::toDto)
            .map(moodTagRepository::loadByEntryId)
            .first()
}