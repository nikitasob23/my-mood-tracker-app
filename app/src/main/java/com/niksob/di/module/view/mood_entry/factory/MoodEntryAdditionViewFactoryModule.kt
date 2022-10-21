package com.niksob.di.module.view.mood_entry.factory

import com.niksob.app.view.mood_entry_addition.factory.MoodEntryAdditionViewFactory
import com.niksob.domain.model.MoodEntry
import com.niksob.domain.navigation.ScreenFactory
import dagger.Module
import dagger.Provides

@Module
class MoodEntryAdditionViewFactoryModule(
    private val moodEntry: MoodEntry,
) {
    @Provides
    fun provideMoodEntryAdditionViewFactory(): ScreenFactory = MoodEntryAdditionViewFactory(moodEntry)
}