package com.niksob.app.view.mood_entry_addition.navigation

import com.niksob.app.view.mood_entry_addition.base.injection.InjectableMoodEntryAdditionView
import com.niksob.domain.model.NavigationableScreenClass
import com.niksob.domain.navigation.navigatable_screen_class.ScreenNavigation
import javax.inject.Inject

open class NavigatableMoodEntryAdditionView : InjectableMoodEntryAdditionView() {

    @Inject
    lateinit var navigation: ScreenNavigation

    @Inject
    lateinit var moodEntriesListScreenClass: NavigationableScreenClass

    protected open fun moveToMoodEntriesScreen() = navigation.moveToNextScreen(moodEntriesListScreenClass)
}