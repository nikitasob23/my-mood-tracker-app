package com.niksob.di.module.usecase

import com.niksob.di.module.repository.MoodEntryRepositoryModule
import com.niksob.domain.data.converter.mood_entry.DbMoodEntryConverter
import com.niksob.di.module.converter.mood_entry.MoodEntryConverterModule
import com.niksob.di.module.converter.mood_tag.MoodTagConverterModule
import com.niksob.di.module.repository.MoodTagRepositoryModule
import com.niksob.domain.data.converter.mood_tag.DbMoodTagConverter
import com.niksob.domain.data.dto.*
import com.niksob.domain.data.repository.mood_entry.MoodEntryRepository
import com.niksob.domain.data.repository.mood_entry.observation.loading.ObservableLoadableMoodEntryRepository
import com.niksob.domain.data.repository.mood_tag.MoodTagRepository
import com.niksob.domain.data.repository.mood_tag.observation.saving.ObservableUpdatableMoodTagRepository
import com.niksob.domain.usecase.db.mood_entry.LoadMoodEntriesByUserIdAndDateUseCase
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        MoodEntryRepositoryModule::class,
        MoodTagRepositoryModule::class,
        MoodEntryConverterModule::class,
        MoodTagConverterModule::class,
    ]
)
class LoadMoodEntriesByUserIdAndDateUseCaseModule {
    @Provides
    fun provideLoadMoodEntriesByUserIdUseCase(
        entryRepo: MoodEntryRepository,
        tagRepo: MoodTagRepository,
        entryConverter: DbMoodEntryConverter,
        tagConverter: DbMoodTagConverter,
    ) =
        LoadMoodEntriesByUserIdAndDateUseCase(
            entryRepo = entryRepo,
            tagRepo = tagRepo,
            dbMoodEntryConverter = entryConverter,
            dbMoodTagConverter = tagConverter,
        )

    @Provides
    fun provideObservableLoadMoodEntriesByUserIdUseCase(
        moodEntryRepository: ObservableLoadableMoodEntryRepository<MoodEntriesDataDto, MoodEntriesDto>,
        moodTagRepository: ObservableUpdatableMoodTagRepository<MoodTagDataDto, MoodTagsFirebaseDto>,
        moodEntryConverter: DbMoodEntryConverter,
        moodTagConverter: DbMoodTagConverter,
    ): com.niksob.domain.usecase.db.mood_entry.observation.LoadMoodEntriesByUserIdAndDateUseCase =
        com.niksob.domain.usecase.db.mood_entry.observation.LoadMoodEntriesByUserIdAndDateUseCaseImpl(
        moodEntryRepository = moodEntryRepository,
        moodTagRepository = moodTagRepository,
        moodEntryConverter = moodEntryConverter,
        moodTagConverter = moodTagConverter,
    )
}