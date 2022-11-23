package com.niksob.di.module.view.mood_entry_day.ui_component

import com.niksob.app.view.mood_entry_day.navigation.MoodEntryDayScreenNavigation
import com.niksob.data.model.ClickAction
import com.niksob.domain.model.MoodEntryId
import dagger.Module
import dagger.Provides

@Module
class MoodEntryClickActionModule {
    @Provides
    fun provideMoodEntryClickAction(
        moodEntryDayScreenNavigation: MoodEntryDayScreenNavigation,
    ): ClickAction<MoodEntryId> =
        object : ClickAction<MoodEntryId> { // Test empty ClickAction. This is not final commit
            override fun onClick(data: MoodEntryId) {
                TODO("Not yet implemented")
            }
        }
}