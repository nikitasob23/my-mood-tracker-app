package com.niksob.app.view.mood_entry_addition.navigation

import com.niksob.app.view.mood_entry_addition.base.injection.InjectableMoodEntryAdditionView
import com.niksob.domain.model.NavigationableScreenClass
import com.niksob.domain.navigation.ScreenNavigationWithNavScreenClass
import javax.inject.Inject

open class NavigatableMoodEntryAdditionView : InjectableMoodEntryAdditionView() {

    @Inject
    lateinit var navigation: ScreenNavigationWithNavScreenClass

    @Inject
    lateinit var moodEntriesListScreenClass: NavigationableScreenClass

    protected open fun moveToMoodEntriesScreen() = navigation.moveToNextScreen(moodEntriesListScreenClass)
}