package com.niksob.app.view.mood.entry.list.navigation

import com.niksob.app.view.mood.entry.list.base.InjectedMoodEntriesListView
import com.niksob.domain.navigation.ScreenNavigationWithNavScreenClass
import javax.inject.Inject

open class NavigatableMoodEntriesListView : InjectedMoodEntriesListView() {

    @Inject
    lateinit var appNavigation: ScreenNavigationWithNavScreenClass
}