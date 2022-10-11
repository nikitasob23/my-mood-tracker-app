package com.niksob.app.view.auth.signup.navigation

import com.niksob.app.view.auth.signup.base.InjectableSignUpView
import com.niksob.domain.model.NavigationableScreenClass
import com.niksob.domain.navigation.ScreenNavigationWithNavScreenClass
import javax.inject.Inject

open class NavigatableSignUpView : InjectableSignUpView() {
    @Inject
    lateinit var navigation: ScreenNavigationWithNavScreenClass

    @Inject
    lateinit var moodEntriesViewClass: NavigationableScreenClass

    protected open fun moveToMoodEntriesScreen() = navigation.moveToNextScreen(moodEntriesViewClass)

    protected open fun moveToPreviousScreen() = navigation.moveToPreviousScreen()
}