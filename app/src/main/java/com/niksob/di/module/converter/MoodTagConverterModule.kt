package com.niksob.di.module.converter

import com.niksob.data.converter.DbMoodTagConverterImpl
import com.niksob.domain.data.converter.DbMoodTagConverter
import com.niksob.domain.data.converter.MoodColorIdConverter
import dagger.Module
import dagger.Provides

@Module(includes = [MoodColorIdConverterModule::class])
class MoodTagConverterModule {

    @Provides
    fun provideConverter(colorIdConverter: MoodColorIdConverter): DbMoodTagConverter =
        DbMoodTagConverterImpl(colorIdConverter)
}