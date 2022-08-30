package com.niksob.app.view.main.activity.navigation

import com.niksob.app.view.auth.LoginView
import com.niksob.app.view.main.activity.injection.InjectableComponentInitializer
import com.niksob.app.view.moodentry.MoodEntriesView
import com.niksob.domain.navigation.ScreenNavigation
import javax.inject.Inject

open class MainActivityWithNavigation : InjectableComponentInitializer() {

    @Inject
    lateinit var navigation: ScreenNavigation

    @Inject
    lateinit var loginViewClass: Class<LoginView>

    @Inject
    lateinit var moodEntriesViewClass: Class<MoodEntriesView>
}