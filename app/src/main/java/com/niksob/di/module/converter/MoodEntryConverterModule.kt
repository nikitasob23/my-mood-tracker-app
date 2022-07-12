package com.niksob.di.module.converter

import com.niksob.data.converter.DbMoodEntryConverterImpl
import com.niksob.domain.data.converter.DbMoodEntryConverter
import com.niksob.domain.data.converter.MoodColorIdConverter
import com.niksob.domain.data.converter.MoodEmojiIdConverter
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        MoodColorConverterModule::class,
        MoodEmojiIdConverterModule::class,
    ]
)
class MoodEntryConverterModule {

    @Provides
    fun provideConverter(
        colorIdConverter: MoodColorIdConverter,
        emojiIdConverter: MoodEmojiIdConverter,
    ): DbMoodEntryConverter = DbMoodEntryConverterImpl(colorIdConverter, emojiIdConverter)
}