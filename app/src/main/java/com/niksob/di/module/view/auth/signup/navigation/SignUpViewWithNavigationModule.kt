package com.niksob.di.module.view.auth.signup.navigation

import com.niksob.app.view.mood.entry.list.toast.InjectableMoodEntriesListViewWithToastMessage
import com.niksob.di.module.navigation.AppScreenNavigationWithNavScreenClassModule
import com.niksob.domain.model.NavigationableScreenClass
import dagger.Module
import dagger.Provides

@Module(includes = [AppScreenNavigationWithNavScreenClassModule::class])
class SignUpViewWithNavigationModule {
    @Provides
    fun provideMoodEntriesListScreenClass() =
        NavigationableScreenClass(InjectableMoodEntriesListViewWithToastMessage::class.java)
}