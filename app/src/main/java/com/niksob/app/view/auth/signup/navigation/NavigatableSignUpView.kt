package com.niksob.app.view.auth.signup.navigation

import com.niksob.app.view.auth.signup.base.InjectableSignUpView
import com.niksob.domain.model.NavigationableScreenClass
import com.niksob.domain.navigation.AppScreenNavigation
import javax.inject.Inject

open class NavigatableSignUpView : InjectableSignUpView() {
    @Inject
    lateinit var appNavigation: AppScreenNavigation

    @Inject
    lateinit var moodEntriesViewClass: NavigationableScreenClass

    protected open fun moveToMoodEntriesScreen() = appNavigation.goToNextView(moodEntriesViewClass)

    protected open fun moveToPreviousScreen() = appNavigation.goToPreviousView()
}