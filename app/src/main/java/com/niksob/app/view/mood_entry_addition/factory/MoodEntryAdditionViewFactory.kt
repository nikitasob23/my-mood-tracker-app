package com.niksob.app.view.mood_entry_addition.factory

import com.niksob.app.view.mood_entry_addition.base.BaseMoodEntryAdditionView
import com.niksob.app.view.provider.ViewClassProvider
import com.niksob.domain.model.MoodEntry
import com.niksob.domain.navigation.NavigationableScreen
import com.niksob.domain.navigation.ScreenFactory

class MoodEntryAdditionViewFactory(
    private val moodEntry: MoodEntry,
) : ScreenFactory {

    override fun create(): NavigationableScreen {
        val screenClass = ViewClassProvider.MOOD_ENTRY_ADDITION_VIEW.clazz
        val screen = screenClass.newInstance()
        (screen as BaseMoodEntryAdditionView).moodEntry = moodEntry
        return screen
    }
}