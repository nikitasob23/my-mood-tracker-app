package com.niksob.di.module.view.mood_entry.navigation

import com.niksob.app.view.provider.ViewClassProvider
import com.niksob.di.module.navigation.ScreenNavigationModule
import com.niksob.di.module.view.mood_entry.factory.MoodEntryAdditionViewFactoryModule
import com.niksob.domain.model.NavigationableScreenClass
import com.niksob.domain.navigation.NavigationableScreen
import com.niksob.domain.navigation.ScreenFactory
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        ScreenNavigationModule::class,
        MoodEntryAdditionViewFactoryModule::class,
    ]
)
class NavigatableMoodEntryAdditionViewModule {
    @Provides
    fun provideMoodEntriesListScreenViewClass(
        navigationableScreenClass: Class<out NavigationableScreen>,
        factory: ScreenFactory
    ) = NavigationableScreenClass(
        clazz = navigationableScreenClass,
        factory = factory,
    )

    @Provides
    fun provideNavigationableScreenClass() = ViewClassProvider.MOOD_ENTRY_ADDITION_VIEW.clazz
}