package com.niksob.di.module.converter

import com.niksob.data.converter.DataConverter
import com.niksob.data.converter.MoodEntryDegreeToTitleConverter
import com.niksob.data.provider.AppStringProvider
import com.niksob.di.module.provider.AppStringProviderModule
import dagger.Module
import dagger.Provides

@Module(includes = [AppStringProviderModule::class])
class MoodEntryDegreeToTitleConverterModule {
    @Provides
    fun provideMoodEntryDegreeToTitleConverter(stringProvider: AppStringProvider): DataConverter<Int, String> =
        MoodEntryDegreeToTitleConverter(stringProvider)
}