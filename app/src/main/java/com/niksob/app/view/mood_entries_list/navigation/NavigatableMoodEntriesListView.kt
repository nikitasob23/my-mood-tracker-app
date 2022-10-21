package com.niksob.app.view.mood_entries_list.navigation

import com.niksob.app.view.mood_entries_list.base.MoodEntriesListView
import com.niksob.domain.model.MoodEntry
import com.niksob.domain.model.NavigationableScreenClass

open class NavigatableMoodEntriesListView : MoodEntriesListView() {

    lateinit var moodEntriesAdditionClass: NavigationableScreenClass

    protected open fun moveToMoodEntryAdditionScreen(moodEntry: MoodEntry) = moveToNextScreen(moodEntriesAdditionClass)
}