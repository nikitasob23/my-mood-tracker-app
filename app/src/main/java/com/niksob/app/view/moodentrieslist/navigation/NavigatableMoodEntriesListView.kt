package com.niksob.app.view.moodentrieslist.navigation

import com.niksob.app.view.moodentrieslist.base.InjectedMoodEntriesListView
import com.niksob.domain.model.MoodEntry
import com.niksob.domain.navigation.ScreenFactory
import com.niksob.domain.navigation.ScreenNavigationByScreenFactory
import javax.inject.Inject

abstract class NavigatableMoodEntriesListView : InjectedMoodEntriesListView() {

    @Inject
    lateinit var navigation: ScreenNavigationByScreenFactory

    lateinit var moodEntryAdditionViewFactory: ScreenFactory

    protected open fun moveMoodEntryAdditionScreen(moodEntry: MoodEntry) =
        navigation.moveToNextScreen(moodEntryAdditionViewFactory)
}