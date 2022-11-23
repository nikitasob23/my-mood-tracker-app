package com.niksob.di.module.converter

import android.content.Context
import com.niksob.app.converter.UIMoodEntryConverter
import com.niksob.data.converter.DataConverter
import com.niksob.data.model.ClickAction
import com.niksob.data.model.UIMoodEntries
import com.niksob.data.model.UIMoodTag
import com.niksob.di.module.app.ContextModule
import com.niksob.di.module.view.mood_entry_day.ui_component.MoodEntryClickActionModule
import com.niksob.domain.data.converter.MoodColorIdConverter
import com.niksob.domain.data.converter.MoodEmojiIdConverter
import com.niksob.domain.model.mood_entry.MoodEntries
import com.niksob.domain.model.MoodEntryId
import com.niksob.domain.model.mood_tag.MoodTag
import dagger.Module
import dagger.Provides

@Module(includes = [
    ContextModule::class,
    UIMoodTagConverterModule::class,
    MoodEntryDegreeToTitleConverterModule::class,
    MoodEmojiIdConverterModule::class,
    MoodColorIdConverterModule::class,
    MoodEntryClickActionModule::class,
])
class UIMoodEntryConverterModule {
    @Provides
    fun provideUIMoodEntryConverter(
        context: Context,
        moodTagUIConverter: DataConverter<MoodTag, UIMoodTag>,
        moodEntryDegreeToTitleConverter: DataConverter<Int, String>,
        emojiIdConverter: MoodEmojiIdConverter,
        colorIdConverter: MoodColorIdConverter,
        clickAction: ClickAction<MoodEntryId>,
    ): DataConverter<MoodEntries, UIMoodEntries> =
        UIMoodEntryConverter(
            context = context,
            moodTagUIConverter = moodTagUIConverter,
            moodEntryDegreeToTitleConverter = moodEntryDegreeToTitleConverter,
            emojiIdConverter = emojiIdConverter,
            colorIdConverter = colorIdConverter,
            clickAction = clickAction,
        )
}