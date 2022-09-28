package com.niksob.app.view.moodentrieslist.navigation

import com.niksob.app.view.moodentrieslist.base.InjectedMoodEntriesListView
import com.niksob.domain.navigation.ScreenNavigationWithNavScreenClass
import javax.inject.Inject

open class NavigatableMoodEntriesListView : InjectedMoodEntriesListView() {

    @Inject
    lateinit var appNavigation: ScreenNavigationWithNavScreenClass
}