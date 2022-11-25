package com.niksob.app.view.mood_entry_day.ui_component

import com.niksob.app.view.mood_entry_day.navigation.MoodEntryDayScreenNavigation
import com.niksob.data.model.ClickAction
import com.niksob.domain.model.MoodEntryId

class MoodEntryClickAction(
    private val moodEntryDayScreenNavigation: MoodEntryDayScreenNavigation,
) : ClickAction<MoodEntryId> {

    override fun onClick(data: MoodEntryId) {
        moodEntryDayScreenNavigation.moveToMoodEntryScreen(data)
    }
}