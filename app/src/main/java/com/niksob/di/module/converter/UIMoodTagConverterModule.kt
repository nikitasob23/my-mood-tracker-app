package com.niksob.di.module.converter

import com.niksob.app.converter.UIMoodTagConverter
import com.niksob.data.converter.DataConverter
import com.niksob.data.model.UIMoodTag
import com.niksob.domain.data.converter.MoodColorIdConverter
import com.niksob.domain.model.mood_tag.MoodTag
import dagger.Module
import dagger.Provides

@Module
class UIMoodTagConverterModule {
    @Provides
    fun provideUIMoodTagConverter(colorIdConverter: MoodColorIdConverter): DataConverter<MoodTag, UIMoodTag> =
        UIMoodTagConverter(colorIdConverter)
}