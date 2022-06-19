package com.niksob.di.module.converter

import com.niksob.data.converter.MoodEmojiIdConverterImpl
import com.niksob.di.module.provider.AppDrawableIdProviderModule
import com.niksob.domain.data.converter.MoodEmojiIdConverter
import com.niksob.domain.data.provider.AppDrawableIdProvider
import dagger.Module
import dagger.Provides

@Module(includes = [AppDrawableIdProviderModule::class])
class MoodEmojiIdConverterModule {
    @Provides
    fun provideMoodEmojiIdConverter(appDrawableIdProvider: AppDrawableIdProvider): MoodEmojiIdConverter =
        MoodEmojiIdConverterImpl(appDrawableIdProvider)
}
