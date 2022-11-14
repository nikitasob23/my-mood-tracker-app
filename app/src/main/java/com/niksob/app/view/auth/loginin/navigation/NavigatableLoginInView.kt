package com.niksob.app.view.auth.loginin.navigation

import com.niksob.app.view.auth.loginin.base.InjectableLoginInView
import com.niksob.domain.model.NavigationableScreenClass
import com.niksob.domain.navigation.navigatable_screen_class.ScreenNavigation
import javax.inject.Inject

open class NavigatableLoginInView : InjectableLoginInView() {

    @Inject
    lateinit var appNavigation: ScreenNavigation

    @Inject
    lateinit var moodEntriesViewClass: NavigationableScreenClass

    protected open fun moveToMoodEntriesView() = appNavigation.moveToNextScreen(moodEntriesViewClass)

    protected open fun moveToPreviousView() = appNavigation.moveToPreviousScreen()
}