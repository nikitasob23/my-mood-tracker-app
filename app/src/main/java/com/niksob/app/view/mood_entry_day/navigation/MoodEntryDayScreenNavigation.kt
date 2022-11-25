package com.niksob.app.view.mood_entry_day.navigation

import com.niksob.app.view.base.factory.ViewFactory
import com.niksob.app.view.base.navigation.PreviousViewNavigation
import com.niksob.domain.model.MoodEntryId
import com.niksob.domain.navigation.AppScreenNavigation

open class MoodEntryDayScreenNavigation(
    private val screenNavigation: AppScreenNavigation,
    private val moodEntryUIViewFactory: ViewFactory<MoodEntryId>,
) : PreviousViewNavigation(screenNavigation) {
    fun moveToMoodEntryScreen(moodEntryId: MoodEntryId) {
        val moodEntryUIView = moodEntryUIViewFactory.create(moodEntryId)
        screenNavigation.moveToNextScreen(moodEntryUIView)
    }
}