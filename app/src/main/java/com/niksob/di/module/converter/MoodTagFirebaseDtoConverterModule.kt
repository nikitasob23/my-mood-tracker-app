package com.niksob.di.module.converter

import com.niksob.data.converter.firebase_dto_converter.base.FirebaseDtoConverter
import com.niksob.data.converter.firebase_dto_converter.mood_entry.MoodEntryFirebaseDtoConverter
import com.niksob.data.converter.firebase_dto_converter.mood_tag.MoodTagFirebaseDtoConverter
import com.niksob.domain.data.dto.MoodTagsDto
import com.niksob.domain.data.dto.MoodTagsFirebaseDto
import dagger.Module
import dagger.Provides

@Module
class MoodTagFirebaseDtoConverterModule {
    @Provides
    fun provideMoodTagFirebaseDtoConverter(): FirebaseDtoConverter<MoodTagsFirebaseDto> = MoodTagFirebaseDtoConverter()
}