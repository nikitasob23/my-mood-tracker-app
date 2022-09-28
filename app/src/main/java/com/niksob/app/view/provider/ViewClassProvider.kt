package com.niksob.app.view.provider

import com.niksob.app.view.auth.login.navigation.InjectedNavigatableLoginView
import com.niksob.app.view.auth.loginin.toast.InjectableLoginInViewWithToastMessages
import com.niksob.app.view.auth.signup.toast.InjectedSignUpViewWithToastMessages
import com.niksob.app.view.moodentrieslist.logger.InjectedLoggableMoodEntriesListViewWithEntriesLoader
import com.niksob.domain.navigation.NavigationableScreen

enum class ViewClassProvider(val clazz : Class<out NavigationableScreen>) {

    LOGIN_VIEW(InjectedNavigatableLoginView::class.java),

    LOGIN_IN_VIEW(InjectableLoginInViewWithToastMessages::class.java),

    SIGN_UP_VIEW(InjectedSignUpViewWithToastMessages::class.java),

    MOOD_ENTRIES_LIST_VIEW(InjectedLoggableMoodEntriesListViewWithEntriesLoader::class.java)
}