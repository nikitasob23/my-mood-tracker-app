package com.niksob.app.view.mood_entry_day.navigation

import com.niksob.app.view.base.navigation.view_navigation.PreviousViewNavigation
import com.niksob.domain.model.MoodEntryId
import com.niksob.domain.model.NavigationableScreenClass
import com.niksob.domain.navigation.navigatable_screen_class.ScreenNavigation

open class MoodEntryDayScreenNavigation(
    private val navigation: ScreenNavigation,
    private val moodEntryViewClass: NavigationableScreenClass,
) : PreviousViewNavigation(navigation) {

    open fun moveToMoodEntryScreen(moodEntryId: MoodEntryId) = navigation.moveToNextScreen(moodEntryViewClass)
}