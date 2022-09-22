package com.niksob.app.view.mood.entry.list.navigation

import com.niksob.app.view.mood.entry.list.InjectableMoodEntriesListView
import com.niksob.domain.navigation.ScreenNavigationWithNavScreenClass
import javax.inject.Inject

open class NavigatableMoodEntriesListView : InjectableMoodEntriesListView() {

    @Inject
    lateinit var appNavigation: ScreenNavigationWithNavScreenClass
}