package com.niksob.di.module.usecase

import com.niksob.di.module.repository.MoodEntryRepositoryModule
import com.niksob.domain.data.converter.DbMoodEntryConverter
import com.niksob.di.module.converter.MoodEntryConverterModule
import com.niksob.di.module.converter.MoodTagConverterModule
import com.niksob.di.module.repository.MoodTagRepositoryModule
import com.niksob.domain.data.converter.DbMoodTagConverter
import com.niksob.domain.data.repository.MoodEntryRepository
import com.niksob.domain.data.repository.MoodTagRepository
import com.niksob.domain.usecase.db.LoadMoodEntriesByUserIdUseCase
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
class LoadMoodEntriesByUserIdUseCaseModule {
    @Provides
    fun provideLoadMoodEntriesByUserIdUseCase(
        entryRepo: MoodEntryRepository,
        tagRepo: MoodTagRepository,
        entryConverter: DbMoodEntryConverter,
        tagConverter: DbMoodTagConverter,
    ) =
        LoadMoodEntriesByUserIdUseCase(
            entryRepo = entryRepo,
            tagRepo = tagRepo,
            dbMoodEntryConverter = entryConverter,
            dbMoodTagConverter = tagConverter,
        )
}