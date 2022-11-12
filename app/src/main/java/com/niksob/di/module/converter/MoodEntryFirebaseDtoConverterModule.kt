package com.niksob.di.module.converter

import com.niksob.data.converter.firebase_dto_converter.base.FirebaseDtoConverter
import com.niksob.data.converter.firebase_dto_converter.mood_entry.MoodEntryFirebaseDtoConverter
import com.niksob.domain.data.dto.MoodEntriesDto
import dagger.Module
import dagger.Provides

@Module
class MoodEntryFirebaseDtoConverterModule {
    @Provides
    fun provideMoodEntryFirebaseDtoConverter(): FirebaseDtoConverter<MoodEntriesDto> = MoodEntryFirebaseDtoConverter()
}