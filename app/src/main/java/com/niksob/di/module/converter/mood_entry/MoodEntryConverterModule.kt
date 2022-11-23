package com.niksob.di.module.converter.mood_entry

import com.niksob.data.converter.mood_entry.DbMoodEntryConverterImpl
import com.niksob.di.module.converter.MoodTagConverterModule
import com.niksob.domain.data.converter.mood_entry.DbMoodEntryConverter
import com.niksob.domain.data.converter.mood_tag.DbMoodTagConverter
import dagger.Module
import dagger.Provides

@Module(includes = [MoodTagConverterModule::class])
class MoodEntryConverterModule {

    @Provides
    fun provideConverter(moodTagConverter: DbMoodTagConverter): DbMoodEntryConverter =
        DbMoodEntryConverterImpl(moodTagConverter)
}