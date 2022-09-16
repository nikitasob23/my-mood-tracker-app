package com.niksob.app.view.auth.loginin.navigation

import com.niksob.app.view.auth.loginin.InjectableLoginInView
import com.niksob.domain.model.NavigationableScreenClass
import com.niksob.domain.navigation.AppScreenNavigation
import javax.inject.Inject
import javax.inject.Named

open class NavigatableLoginInView : InjectableLoginInView() {

    @Inject
    lateinit var appNavigation: AppScreenNavigation

    @Inject
    @Named("mood_entries_view_class")
    lateinit var moodEntriesViewClass: NavigationableScreenClass

    protected open fun moveToMoodEntriesView() = appNavigation.goToNextView(moodEntriesViewClass)

    protected open fun moveToPreviousView() = appNavigation.goToPreviousView()
}