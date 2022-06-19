package com.niksob.di.module.usecase

import com.niksob.data.converter.DbMoodEntryConverterImpl
import com.niksob.di.module.repository.MoodEntryRepositoryModule
import com.niksob.domain.data.converter.DbMoodEntryConverter
import com.niksob.data.converter.MoodColorIdConverterImpl
import com.niksob.di.module.converter.MoodColorConverterModule
import com.niksob.di.module.converter.MoodEmojiIdConverterModule
import com.niksob.domain.data.converter.MoodEmojiIdConverter
import com.niksob.domain.data.repository.MoodEntryRepository
import com.niksob.domain.usecase.db.LoadMoodEntriesByUserIdUseCase
import dagger.Module
import dagger.Provides

@Module(includes = [
    MoodEntryRepositoryModule::class,
    MoodColorConverterModule::class,
    MoodEmojiIdConverterModule::class,
])
class LoadMoodEntriesByUserIdUseCaseModule {
    @Provides
    fun provideLoadMoodEntriesByUserIdUseCase(
        repo: MoodEntryRepository,
        entryConverter: DbMoodEntryConverter
    ) =
        LoadMoodEntriesByUserIdUseCase(repo, entryConverter)

    @Provides
    fun provideDbMoodEntryConverter(
        moodColorConverter: MoodColorIdConverterImpl,
        moodEmojiIdConverter: MoodEmojiIdConverter,
    ): DbMoodEntryConverter =
        DbMoodEntryConverterImpl(moodColorConverter, moodEmojiIdConverter)
}