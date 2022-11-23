package com.niksob.di.module.converter.mood_tag

import com.niksob.data.converter.mood_tag.DbMoodTagConverterImpl
import com.niksob.domain.data.converter.mood_tag.DbMoodTagConverter
import dagger.Module
import dagger.Provides

@Module
class MoodTagConverterModule {
    @Provides
    fun provideConverter(): DbMoodTagConverter =
        DbMoodTagConverterImpl()
}