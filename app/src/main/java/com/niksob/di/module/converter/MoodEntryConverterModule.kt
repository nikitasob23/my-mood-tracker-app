package com.niksob.di.module.converter

import com.niksob.data.converter.DbMoodEntryConverterImpl
import com.niksob.domain.data.converter.DbMoodEntryConverter
import com.niksob.domain.data.converter.DbMoodTagConverter
import com.niksob.domain.data.converter.MoodColorIdConverter
import com.niksob.domain.data.converter.MoodEmojiIdConverter
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        MoodTagConverterModule::class,
        MoodColorConverterModule::class,
        MoodEmojiIdConverterModule::class,
    ]
)
class MoodEntryConverterModule {

    @Provides
    fun provideConverter(
        moodTagConverter: DbMoodTagConverter,
        moodColorIdConverter: MoodColorIdConverter,
        moodEmojiIdConverter: MoodEmojiIdConverter,
    ): DbMoodEntryConverter = DbMoodEntryConverterImpl(
        moodTagConverter = moodTagConverter,
        moodColorIdConverter = moodColorIdConverter,
        moodEmojiIdConverter = moodEmojiIdConverter,
    )
}