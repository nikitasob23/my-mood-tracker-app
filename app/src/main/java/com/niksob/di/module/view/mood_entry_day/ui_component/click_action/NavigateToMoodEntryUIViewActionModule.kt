package com.niksob.di.module.view.mood_entry_day.ui_component.click_action

import com.niksob.app.view.mood_entry_day.navigation.MoodEntryDayScreenNavigation
import com.niksob.app.view.mood_entry_day.ui_component.MoodEntryClickAction
import com.niksob.data.model.ClickAction
import com.niksob.di.module.view.mood_entry_day.navigation.MoodEntryDayScreenNavigationModule
import com.niksob.domain.model.MoodEntryId
import dagger.Module
import dagger.Provides

@Module(includes = [MoodEntryDayScreenNavigationModule::class])
class NavigateToMoodEntryUIViewActionModule {
    @Provides
    fun provideMoodEntryClickAction(navigation: MoodEntryDayScreenNavigation): ClickAction<MoodEntryId> =
        MoodEntryClickAction(navigation)
}