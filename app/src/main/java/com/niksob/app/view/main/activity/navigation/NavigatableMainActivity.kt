package com.niksob.app.view.main.activity.navigation

import com.niksob.app.view.auth.LoginView
import com.niksob.app.view.main.activity.injection.InjectableComponentInitializer
import com.niksob.app.view.mood.entry.MoodEntriesView
import com.niksob.domain.navigation.ScreenNavigation
import javax.inject.Inject

open class NavigatableMainActivity : InjectableComponentInitializer() {

    @Inject
    lateinit var navigation: ScreenNavigation

    @Inject
    lateinit var loginViewClass: Class<LoginView>

    @Inject
    lateinit var moodEntriesViewClass: Class<MoodEntriesView>
}