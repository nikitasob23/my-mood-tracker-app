package com.niksob.di.module.view.auth.signup.navigation

import com.niksob.app.view.provider.ViewClassProvider
import com.niksob.di.module.navigation.ScreenNavigationModule
import com.niksob.domain.model.NavigationableScreenClass
import dagger.Module
import dagger.Provides

@Module(includes = [ScreenNavigationModule::class])
class SignUpViewWithNavigationModule {
    @Provides
    fun provideMoodEntriesListScreenClass() =
        NavigationableScreenClass(ViewClassProvider.MOOD_ENTRY_DAY_VIEW.clazz)
}