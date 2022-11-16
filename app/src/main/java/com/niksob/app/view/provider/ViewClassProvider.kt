package com.niksob.app.view.provider

import com.niksob.app.view.auth.login.navigation.InjectedNavigatableLoginView
import com.niksob.app.view.auth.loginin.toast.InjectableLoginInViewWithToastMessages
import com.niksob.app.view.auth.signup.logger.InjectedLoggableSignUpView
import com.niksob.app.view.mood_entry_addition.logger.injection.InjectedLoggableMoodEntryAdditionView
import com.niksob.app.view.mood_entry_day.injection.InjectedMoodEntryDayUIView
import com.niksob.domain.navigation.NavigationableScreen

enum class ViewClassProvider(val clazz : Class<out NavigationableScreen>) {

    LOGIN_VIEW(InjectedNavigatableLoginView::class.java),

    LOGIN_IN_VIEW(InjectableLoginInViewWithToastMessages::class.java),

    SIGN_UP_VIEW(InjectedLoggableSignUpView::class.java),

    MOOD_ENTRIES_LIST_VIEW(InjectedMoodEntryDayUIView::class.java),

    MOOD_ENTRY_ADDITION_VIEW(InjectedLoggableMoodEntryAdditionView::class.java),
}