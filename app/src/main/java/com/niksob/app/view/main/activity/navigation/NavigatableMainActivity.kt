package com.niksob.app.view.main.activity.navigation

import com.niksob.app.view.main.activity.base.injection.InjectableComponentInitializer
import com.niksob.domain.navigation.NavigationableScreen
import com.niksob.domain.navigation.BaseScreenNavigation
import javax.inject.Inject
import javax.inject.Named

open class NavigatableMainActivity : InjectableComponentInitializer() {

    @Inject
    lateinit var navigation: BaseScreenNavigation

    @Inject
    @Named("login_view_class")
    lateinit var loginViewClass: Class<out NavigationableScreen>

    @Inject
    @Named("mood_entries_view_class")
    lateinit var moodEntriesViewClass: Class<out NavigationableScreen>
}