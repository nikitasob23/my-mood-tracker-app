package com.niksob.app.view.auth.signup

import com.niksob.domain.model.NavigationableScreenClass
import com.niksob.domain.navigation.AppScreenNavigation
import javax.inject.Inject
import javax.inject.Named

open class NavigatableSignUpView : InjectableSignUpView() {
    @Inject
    lateinit var appNavigation: AppScreenNavigation

    @Inject
    @Named("mood_entries_view_class")
    lateinit var moodEntriesViewClass: NavigationableScreenClass

    protected fun moveToMoodEntriesScreen() = appNavigation.goToNextView(moodEntriesViewClass)
}